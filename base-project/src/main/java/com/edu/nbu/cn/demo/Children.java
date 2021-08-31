package com.edu.nbu.cn.demo;

/**
 *
 * @version 1.0
 * @Date 2021/6/30 11:26 上午
 * @since 1.0
 */
public class Children extends Parent{

    @Override
    public  void sayHello() {
        synchronized (this){
            super.sayHello();
            System.out.println("hello,this is children");
        }
        System.out.println("children lock released!");
    }
}
