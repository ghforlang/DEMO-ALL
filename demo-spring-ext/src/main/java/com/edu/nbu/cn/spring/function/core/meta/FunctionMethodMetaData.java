package com.edu.nbu.cn.spring.function.core.meta;

import java.util.function.Function;

/**
 * @author laoshi . hua
 * @version 1.0 2022/6/18-6:49 PM
 * @since 1.0
 */

public class FunctionMethodMetaData {
    private String beanName;
    private Class<?> beanClazz;
    private String identifier;
    private Function function;


    public FunctionMethodMetaData(String beanName, Class<?> beanClazz, String identifier, Function function) {
        this.beanName = beanName;
        this.beanClazz = beanClazz;
        this.identifier = identifier;
        this.function = function;
    }

    public FunctionMethodMetaData() {
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public Class<?> getBeanClazz() {
        return beanClazz;
    }

    public void setBeanClazz(Class<?> beanClazz) {
        this.beanClazz = beanClazz;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }
}
