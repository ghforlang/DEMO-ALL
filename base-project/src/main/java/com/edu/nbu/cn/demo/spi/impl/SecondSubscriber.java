package com.edu.nbu.cn.demo.spi.impl;

import com.edu.nbu.cn.demo.spi.service.Subscriber;

/**
 *
 * @version 1.0
 * @Date 2021/2/5 5:12 下午
 * @since 1.0
 */
public class SecondSubscriber implements Subscriber {

    @Override
    public void subscribe() {
        System.out.println("this is the secondSubscriber!");
    }
}
