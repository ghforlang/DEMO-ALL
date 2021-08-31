package com.edu.nbu.cn.demo.service;

/**
 *
 * @version 1.0
 * @Date 2021/2/7 4:40 下午
 * @since 1.0
 */
public class TestDefault {

    public static void main(String[] args) {
        HelloInterface hi = new HelloService();
        hi.sayHello("zhangsan");
    }
}
