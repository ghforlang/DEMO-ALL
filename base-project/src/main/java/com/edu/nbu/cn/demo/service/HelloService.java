package com.edu.nbu.cn.demo.service;

/**
 *
 * @version 1.0
 * @Date 2021/2/7 4:38 下午
 * @since 1.0
 */
public class HelloService implements HelloInterface,HelloService2{

    @Override
    public String sayHello(String name) {
        //当实现接口有多个同名default方法时，可以通过这种方式指定具体调用父类哪个方法。
        HelloInterface.sayHi();
        return HelloService2.super.sayHello(name);
    }
}
