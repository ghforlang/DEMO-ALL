package com.edu.nbu.cn.apt.meta;

import com.squareup.javapoet.*;

import javax.annotation.processing.Filer;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @version 1.0
 * @Date 2021/8/4 3:28 下午
 * @since 1.0
 * 处理代理类的生成
 */
public class BuildAnnotatedClassesGenerator {
    private static final String SUFFIX = "$Factory";

    /**
     * 工厂类型
     */
    private String qualifiedFactoryName;

    private Map<String,AnnotatedClassMetaData> classMetaDataMap = new ConcurrentHashMap<>();

    public BuildAnnotatedClassesGenerator(String qualifiedFactoryName) {
        this.qualifiedFactoryName = qualifiedFactoryName;
    }

    public void add(AnnotatedClassMetaData metaData ){
        AnnotatedClassMetaData existMetaData = classMetaDataMap.get(metaData.getBizId());
        if(Objects.nonNull(existMetaData) && existMetaData.getAnnotatedTypeElement() != metaData.getAnnotatedTypeElement()){
            throw new IllegalArgumentException("the same bizId " + metaData.getBizId() + " has existed[ " + existMetaData.getAnnotatedTypeElement() + "," + metaData.getAnnotatedTypeElement());
        }
        classMetaDataMap.put(metaData.getBizId(),metaData);
    }


    public void generateCode(Elements elementUtils, Filer filer) throws IOException {
        System.out.println("begin to generate Code!");
        TypeElement superClass = elementUtils.getTypeElement(qualifiedFactoryName);
        String factoryClassName = superClass.getSimpleName().toString() + SUFFIX;
        String qualifiedFactoryClassName = superClass.getQualifiedName().toString() + SUFFIX;

        PackageElement pkgElement = elementUtils.getPackageOf(superClass);
        String pkgName = pkgElement.isUnnamed() ? null : pkgElement.getQualifiedName().toString();


        ClassName returnClassName = ClassName.get("com.edu.nbu.cn.alltest.apt","IShape");
        MethodSpec methodSpec = MethodSpec.methodBuilder("draw")
              .returns(returnClassName)
              .build();


        MethodSpec.Builder methodBuilder = methodSpec.toBuilder()
                .addModifiers(Modifier.PUBLIC)
                .addParameter(String.class,"bizId",Modifier.FINAL);

        // 参数校验
        CodeBlock conditionCodeBlock = CodeBlock.of("if(bizId == null || bizId.length() == 0)");
        CodeBlock statementCodeBlock = CodeBlock.of("throw new IllegalArgumentException($S)","bizId can not be null!");
        methodBuilder.beginControlFlow(conditionCodeBlock)
                .addStatement(statementCodeBlock)
                .endControlFlow();

        // create方法生成实现
        for(AnnotatedClassMetaData metaData : classMetaDataMap.values()){
            CodeBlock codeBlock = CodeBlock.of("if(bizId.equals($S))",metaData.getBizId());
            CodeBlock statCodeBlock = CodeBlock.of("return new $L();",metaData.getAnnotatedTypeElement());
            methodBuilder.beginControlFlow(codeBlock)
                    .addCode(statCodeBlock)
                    .endControlFlow();
        }

        methodBuilder.addStatement("throw new IllegalArgumentException($S + bizId)","unKnown bizId = ");
        TypeSpec spec = TypeSpec.classBuilder(factoryClassName).addModifiers(Modifier.PUBLIC).addMethod(methodBuilder.build()).build();
        JavaFile.builder(pkgName,spec).build().writeTo(filer);
        System.out.println("generate Code finish!");
    }
}
