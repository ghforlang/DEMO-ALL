package com.edu.nbu.cn.spi.impl;

import com.edu.nbu.cn.spi.service.Subscriber;

public class FirstSubscriber implements Subscriber {

    @Override
    public void subscribe() {
        System.out.println("this is the firstSubscriber!");
    }
}
