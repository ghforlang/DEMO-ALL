package com.edu.nbu.cn.alltest.apt;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestApt {

    private static final String APT_CLASS_NAME = "com.edu.nbu.cn.alltest.apt.IShape";
    private static final String APT_CLASS_SUFFIX = "$Factory";
    private static final String APT_METHOD_NAME = "draw";

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> clazz = Class.forName(APT_CLASS_NAME + APT_CLASS_SUFFIX);
        Method method = clazz.getMethod(APT_METHOD_NAME,String.class);
        IShape shape = (IShape) method.invoke(clazz.newInstance(),"circle");
        shape.draw();
    }
}
