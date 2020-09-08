package com.edu.nbu.cn.designpattern.responsibilitychain.consumer;

public interface Consumer {

    Integer getType();

    String getName();

    boolean canConsume();

    boolean isMouslim();
}
