package com.edu.nbu.cn.bytebuddy.model;

import net.bytebuddy.implementation.bind.annotation.BindingPriority;

/**
 * @author laoshi . hua
 * @version 1.0 2023/7/27-2:21 PM
 * @since 1.0
 */
public class Bar  extends Foo{
    @BindingPriority(5)
    public static String sayBar(){
        return "hello bar";
    }

    @BindingPriority(3)
    public static String sayCar(){
        return "hello Carbon";
    }

    @BindingPriority(7)
    public static String sayDar(){
        return "hello Dar";
    }
}
