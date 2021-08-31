package com.edu.nbu.cn.demo.service;

/**
 *
 * @version 1.0
 * @Date 2021/2/7 4:34 下午
 * @since 1.0
 */
public interface HelloInterface {

    default String sayHello(String name){
        System.out.println("HelloInterface hello " + name);
        return "HelloInterface hello " + name;
    }


    static void sayHi(){
        System.out.println("HelloInterface hi!");
    }
}
