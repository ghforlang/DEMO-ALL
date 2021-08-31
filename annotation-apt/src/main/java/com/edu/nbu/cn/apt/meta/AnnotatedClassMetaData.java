package com.edu.nbu.cn.apt.meta;

import com.edu.nbu.cn.apt.anno.Build;

import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.MirroredTypeException;

/**
 * @version 1.0
 * @Date 2021/8/3 8:40 下午
 * @since 1.0
 */
public class AnnotatedClassMetaData {

    /**
     * 被注解class
     */
    private TypeElement annotatedTypeElement;

    /**
     * 使用注解的class内bizId值
     */
    private String bizId;

    /**
     *  注解中type的simpleName
     */
    private String typeSimpleName;

    /**
     * type的完整className
     */
    private String typeQualifiedSupperClassName;

    /**
     * 所属组名
     */
    private String qualifiedGroupName;


    public AnnotatedClassMetaData(TypeElement typeElement){
        if(typeElement == null){
            throw new IllegalArgumentException("typeElement can not be null!");
        }
        this.annotatedTypeElement = typeElement;
        Build buildAnno = typeElement.getAnnotation(Build.class);
        this.bizId = buildAnno.bizId();
        this.qualifiedGroupName = buildAnno.group();

        try{
            // 当前类已经被编译
            Class<?> annotatedClass = buildAnno.type();
            typeSimpleName = annotatedClass.getSimpleName();
            typeQualifiedSupperClassName = annotatedClass.getCanonicalName();
        }catch (MirroredTypeException mte){
            // 若未被编译
            DeclaredType declaredType = (DeclaredType)mte.getTypeMirror();
            TypeElement element = (TypeElement)declaredType.asElement();
            typeSimpleName = element.getSimpleName().toString();
            typeQualifiedSupperClassName = element.getQualifiedName().toString();
        }
    }

    public TypeElement getAnnotatedTypeElement() {
        return annotatedTypeElement;
    }

    public String getBizId() {
        return bizId;
    }

    public String getTypeSimpleName() {
        return typeSimpleName;
    }

    public String getTypeQualifiedSupperClassName() {
        return typeQualifiedSupperClassName;
    }

    public String getQualifiedGroupName() {
        return qualifiedGroupName;
    }
}
