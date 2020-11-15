package com.edu.nbu.cn.demo.reflection;


public class StudentHelper extends AbstractEntityHelper{

    @Override
    public Student create(Param param) {
        Student s = new Student();
        s.setAddress(param.getAddress());
        s.setAge(param.getAge());
        s.setName(param.getName());
        return s;
    }
}
