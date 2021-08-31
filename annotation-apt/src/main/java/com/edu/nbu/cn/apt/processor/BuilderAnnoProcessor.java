package com.edu.nbu.cn.apt.processor;


import com.edu.nbu.cn.apt.meta.AnnotatedClassMetaData;
import com.edu.nbu.cn.apt.meta.BuildAnnotatedClassesGenerator;
import com.edu.nbu.cn.apt.anno.Build;
import com.google.auto.service.AutoService;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.*;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @version 1.0
 * @Date 2021/8/3 8:12 下午
 * @since 1.0
 */
//@SupportedAnnotationTypes("com.edu.nbu.cn.apt.anno.Build")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedOptions("debug")
@AutoService(Processor.class)
public class BuilderAnnoProcessor extends AbstractProcessor {
    private static final Class<Build> anno = Build.class;

    /**
     * 日志工具
     */
    private Messager messager;
    /**
     * Element(接口)，元素工具；这里把java类看成一个由各种元素构成的结构化文件；
     * 比如TypeElement、PackageElement、VariableElement
     */
    private Elements elementUtils;

    /**
     * 支持注解处理器创建文件
     */
    private Filer filer;

    /**
     * 类型工具
     */
    private Types typeUtils;

    /**
     * generatorMap
     */
    private Map<String, BuildAnnotatedClassesGenerator> generatorMap = new HashMap<>();

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        messager = processingEnv.getMessager();
        elementUtils = processingEnv.getElementUtils();
        filer = processingEnv.getFiler();
        typeUtils = processingEnv.getTypeUtils();
        messager.printMessage(Diagnostic.Kind.NOTE,"AnnoProcessor init！");
    }


    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> supportAnnotationTypes = new HashSet<>();
        supportAnnotationTypes.addAll(super.getSupportedAnnotationTypes());
        supportAnnotationTypes.add("com.edu.nbu.cn.apt.anno.Build");
        return supportAnnotationTypes;
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        System.out.println("begin to process!");
        messager.printMessage(Diagnostic.Kind.NOTE,"begin process @Build!");
        for(Element element : roundEnv.getElementsAnnotatedWith(anno)){
            messager.printMessage(Diagnostic.Kind.NOTE,"FactoryAnnoProcessor processing！");
            if(element.getKind() != ElementKind.CLASS){
                messager.printMessage(Diagnostic.Kind.ERROR,"@Build support Class only!");
                throw new UnsupportedOperationException("@Build support Class only!");
            }

            TypeElement typeElement = (TypeElement) element;
            // 封装使用注解的class元数据
            AnnotatedClassMetaData metaData = new AnnotatedClassMetaData(typeElement);
            // 做数据校验
            checkClassMetaData(metaData);
            // 先将元数据分组，准备生成代码
            BuildAnnotatedClassesGenerator generator = generatorMap.get(metaData.getQualifiedGroupName());
            if(generator == null){
                generator = new BuildAnnotatedClassesGenerator(metaData.getQualifiedGroupName());
                generatorMap.put(metaData.getQualifiedGroupName(),generator);
            }
            generator.add(metaData);
        }

        // 代码生成
        try{
            for (BuildAnnotatedClassesGenerator generator : generatorMap.values()) {
                messager.printMessage(Diagnostic.Kind.NOTE,"begin generate code!");
                generator.generateCode(elementUtils, filer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void checkClassMetaData(AnnotatedClassMetaData metaData) {
        TypeElement  type = metaData.getAnnotatedTypeElement();
        if (!type.getModifiers().contains(Modifier.PUBLIC)){
            messager.printMessage(Diagnostic.Kind.ERROR,"class " + type.getQualifiedName().toString() + "is not public!");
            throw new IllegalArgumentException("class " + type.getQualifiedName().toString() + "is not public!");
        }

        if(type.getModifiers().contains(Modifier.ABSTRACT)){
            messager.printMessage(Diagnostic.Kind.ERROR,"class " + type.getQualifiedName().toString() + "is abstract!");
            throw new IllegalArgumentException("class " + type.getQualifiedName().toString() + "is abstract");
        }

        TypeElement superClassType = elementUtils.getTypeElement(metaData.getTypeQualifiedSupperClassName());
        //是接口,那么type应该继承或实现该接口
        if(superClassType.getKind() == ElementKind.INTERFACE){
           if(!type.getInterfaces().contains(superClassType.asType())){
               messager.printMessage(Diagnostic.Kind.ERROR,type.getQualifiedName().toString() + "shoud implement superClassType " + superClassType.getQualifiedName().toString() + "!");
               throw new UnsupportedOperationException(type.getQualifiedName().toString() + "shoud implement superClassType " + superClassType.getQualifiedName().toString() + "!");
           }
        }else{
            TypeElement currentClass = type;
            while (true){
                TypeMirror superClass = currentClass.getSuperclass();
                // 向上寻找直到Object
                if(TypeKind.NONE == superClass.getKind()){
                    messager.printMessage(Diagnostic.Kind.ERROR,currentClass.getQualifiedName().toString() + "shoud implement superClassType " + superClassType.getQualifiedName().toString() + "!");
                    throw new IllegalArgumentException(currentClass.getQualifiedName().toString() + "shoud implement superClassType " + superClassType.getQualifiedName().toString() + "!");
                }
                if(superClass.toString().equals(metaData.getTypeQualifiedSupperClassName())){
                    break;
                }
                currentClass = (TypeElement) typeUtils.asElement(superClass);
            }
        }

       for(Element element : type.getEnclosedElements()) {
           // 是否有无参构造方法
           if(ElementKind.CONSTRUCTOR == element.getKind()){
               ExecutableElement constructorElement = (ExecutableElement)element;
               if(constructorElement.getParameters().size() == 0 && constructorElement.getModifiers().contains(Modifier.PUBLIC)){
                   return;
               }
           }
       }

       messager.printMessage(Diagnostic.Kind.ERROR,type.getQualifiedName().toString() + "should has a constructor with no args");
       throw new IllegalArgumentException(type.getQualifiedName().toString() + "should has a constructor with no args");
    }
}
