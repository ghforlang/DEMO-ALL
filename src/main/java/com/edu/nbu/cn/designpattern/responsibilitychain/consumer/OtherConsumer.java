package com.edu.nbu.cn.designpattern.responsibilitychain.consumer;

public class OtherConsumer  extends AbstractConsumer{

    public OtherConsumer(Integer type, String name) {
        super(type, name);
    }

    @Override
    public boolean isMouslim() {
        return true;
    }

    @Override
    public boolean canConsume() {
        return type.equals(1);
    }
}
