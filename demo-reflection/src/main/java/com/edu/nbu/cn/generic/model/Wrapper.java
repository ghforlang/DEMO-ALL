package com.edu.nbu.cn.generic.model;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author laoshi . hua
 * @version 1.0 2023/5/25-10:36 AM
 * @since 1.0
 */
public class Wrapper<T>{
    public void initialize(){
        System.out.println("initializing " + this.getClass().getName());
    }
}
