package com.edu.nbu.cn.demo.spi;

import com.edu.nbu.cn.demo.spi.service.Subscriber;

import java.util.ServiceLoader;

public class JDKSpiDemo {

    public static void main(String[] args) {
        ServiceLoader<Subscriber> subscribers = ServiceLoader.load(Subscriber.class);
        for(Subscriber subscriber : subscribers){
            subscriber.subscribe();;
        }
    }
}
