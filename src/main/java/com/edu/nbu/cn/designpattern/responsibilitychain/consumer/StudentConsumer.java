package com.edu.nbu.cn.designpattern.responsibilitychain.consumer;

public class StudentConsumer extends AbstractConsumer {
    public StudentConsumer(Integer type, String name) {
        super(type, name);
    }

    @Override
    public boolean canConsume() {
        return type.equals(1);
    }
}
