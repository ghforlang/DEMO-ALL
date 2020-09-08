package com.edu.nbu.cn.designpattern.responsibilitychain.consumer;

public class TeacherConsumer  extends AbstractConsumer{

    public TeacherConsumer(Integer type, String name) {
        super(type, name);
    }


    @Override
    public boolean canConsume() {
        return type.equals(1);
    }
}
