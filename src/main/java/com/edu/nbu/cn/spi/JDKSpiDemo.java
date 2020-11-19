package com.edu.nbu.cn.spi;

import com.edu.nbu.cn.spi.service.Subscriber;

import java.util.ServiceLoader;

public class JDKSpiDemo {

    public static void main(String[] args) {
        ServiceLoader<Subscriber> subscribers = ServiceLoader.load(Subscriber.class);
        for(Subscriber subscriber : subscribers){
            subscriber.subscribe();;
        }
    }
}
