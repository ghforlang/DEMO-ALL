package com.edu.nbu.cn.ddd.acl;


public class KafakTemplate<T,S> {

    public SendResult send(T  topic, S message){
        System.out.println(topic + "," + message);
        return SendResult.success();
    }
}
