package com.edu.nbu.cn.classloader.demo;

/**
 * @author laoshi . hua
 * @version 1.0 2023/7/27-5:10 PM
 * @since 1.0
 */
public class TestB {
    public void hello(){
        System.out.println("TestB: " + this.getClass().getClassLoader());
    }
}
