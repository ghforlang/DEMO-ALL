package com.edu.nbu.cn.demo.service;

/**
 *
 * @version 1.0
 * @Date 2021/2/7 4:45 下午
 * @since 1.0
 */
public interface HelloService2 {

    default String sayHello(String name){
        System.out.println("interface2 sayHello " + name);
        return "inteface2 sayHello " + name;
    }

    static void sayHi(){
        System.out.println("HelloService2 hi!");
    }

}
