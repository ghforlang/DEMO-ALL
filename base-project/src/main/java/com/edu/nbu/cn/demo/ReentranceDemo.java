package com.edu.nbu.cn.demo;

/**
 *
 * @version 1.0
 * @Date 2021/6/30 11:13 上午
 * @since 1.0
 */
public class ReentranceDemo {

    public static void main(String[] args) {
        Children children = new Children();
        children.sayHello();
    }
}
