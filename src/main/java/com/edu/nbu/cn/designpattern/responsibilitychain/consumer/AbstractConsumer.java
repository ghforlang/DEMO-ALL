package com.edu.nbu.cn.designpattern.responsibilitychain.consumer;

public abstract class AbstractConsumer implements Consumer{
    protected Integer type;
    protected String name;


    protected AbstractConsumer(Integer type, String name) {
        this.type = type;
        this.name = name;
    }

    @Override
    public Integer getType() {
        return type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean canConsume() {
        return false;
    }

    @Override
    public boolean isMouslim() {
        return false;
    }
}
