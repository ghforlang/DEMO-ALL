package com.edu.nbu.cn.demo.javapoet;

import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import sun.reflect.generics.scope.MethodScope;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ClassGenerator {

    public static TypeSpec generate(Class<?> parentClazz,String clazzName){
        if(!validClazz(parentClazz)){
            throw new RuntimeException("invalid parentClazz");
        }

        Method[] methods = parentClazz.getDeclaredMethods();
        List<MethodSpec> methodSpecList = new ArrayList<>();
        Arrays.stream(methods).forEach(method -> methodSpecList.add(MethodGenerator.generate(method)));

        TypeSpec typeSpec = TypeSpec.classBuilder(clazzName)
                .addAnnotation(JavaPoet.class)
                .addModifiers(javax.lang.model.element.Modifier.PUBLIC)
                .addMethods(methodSpecList)
                .addSuperinterface(parentClazz)
                .build();

        return typeSpec;
    }

    public static boolean validClazz(Class<?> clazz){
        if (Objects.isNull(clazz)) {
            return false;
        }
        if(Modifier.isInterface(clazz.getModifiers()) || Modifier.isAbstract(clazz.getModifiers())
            || Modifier.isPublic(clazz.getModifiers())){
            return true;
        }
        return false;
    }

}
