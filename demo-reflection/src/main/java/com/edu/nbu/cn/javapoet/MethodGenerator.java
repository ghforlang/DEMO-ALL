package com.edu.nbu.cn.javapoet;

import com.edu.nbu.cn.javapoet.model.A;
import com.squareup.javapoet.MethodSpec;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Objects;

public class MethodGenerator {

    public static MethodSpec generate(Method method){
        if(!validMethod(method)){
            throw new RuntimeException("invalid method!");
        }

        MethodSpec methodSpec = MethodSpec.methodBuilder(method.getName())
                .addModifiers(javax.lang.model.element.Modifier.PUBLIC)
                .addAnnotation(Override.class)
                .addParameter(A.class,"a")
                .addStatement("$T.out.pringln($S)",System.class,"this is a")
                .returns(String.class)
                .build();
        return methodSpec;
    }

    public static MethodSpec generateAbstract(Method method){
        if(!validMethod(method)){
            throw new RuntimeException("invalid method!");
        }

        MethodSpec methodSpec = MethodSpec.methodBuilder(method.getName())
                .addModifiers(javax.lang.model.element.Modifier.PUBLIC)
                .addAnnotation(Override.class)
                .addParameter(A.class,"a")
                .returns(String.class)
                .build();
        return methodSpec;
    }

    public static boolean validMethod(Method method){
        if(Objects.isNull(method)){
            return false;
        }

        if(Modifier.isPublic(method.getModifiers()) || Modifier.isAbstract(method.getModifiers())){
            return true;
        }

        return false;
    }
}
