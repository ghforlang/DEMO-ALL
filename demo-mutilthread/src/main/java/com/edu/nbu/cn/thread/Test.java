package com.edu.nbu.cn.thread;

/**
 *
 * @version 1.0
 * @Date 2021/5/13 3:52 下午
 * @since 1.0
 */
public class Test {
    public static void main(String[] args) {
        Product product = new Product();
        product.setCount(0L);

        Producer p1 = new Producer(product);
        Producer p2 = new Producer(product);

        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);
        t1.start();
        t2.start();
    }
}
