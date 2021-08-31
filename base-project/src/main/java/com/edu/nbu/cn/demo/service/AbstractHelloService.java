package com.edu.nbu.cn.demo.service;

/**
 *
 * @version 1.0
 * @Date 2021/2/7 4:39 下午
 * @since 1.0
 */
public abstract class AbstractHelloService implements HelloInterface{

    @Override
    public String sayHello(String name) {
        return "abstract hello " + name;
    }
}
