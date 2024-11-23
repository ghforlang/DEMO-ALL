package com.edu.nbu.cn.classloader.demo;

/**
 * @author laoshi . hua
 * @version 1.0 2023/7/27-5:09 PM
 * @since 1.0
 */
public class TestA {
    public static void main(String[] args) {
        TestA testA = new TestA();
        testA.hello();
    }

    public  void hello(){
        System.out.println("TestA: " + this.getClass().getClassLoader());
        TestB testB = new TestB();
        testB.hello();
    }
}
