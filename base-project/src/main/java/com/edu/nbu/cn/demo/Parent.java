package com.edu.nbu.cn.demo;

/**
 *
 * @version 1.0
 * @Date 2021/6/30 11:25 上午
 * @since 1.0
 */
public class Parent {

    public  void sayHello(){
        synchronized (this){
            System.out.println("hello,this is parent");
        }
        System.out.println("parent lock released!");
    }
}
