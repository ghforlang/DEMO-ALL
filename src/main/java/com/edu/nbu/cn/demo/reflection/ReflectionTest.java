package com.edu.nbu.cn.demo.reflection;


import javassist.CannotCompileException;
import javassist.NotFoundException;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class ReflectionTest {

    private static final Param param = new Param();

    static {
        param.setAddress("上海");
        param.setAge(10);
        param.setName("张三");
    }


    public static void main(String[] args) throws CannotCompileException, InstantiationException,
            IllegalAccessException, NotFoundException,
            IOException, InvocationTargetException {
        test1();
        test2();
        test3();
    }

    private static void test1(){
        long start = System.currentTimeMillis();
        StudentHelper studentHelper = new StudentHelper();
        Student s = studentHelper.create(param);
        System.out.println("time cost :  " + (System.currentTimeMillis() - start) + " \n" + s.toString());
    }

    private static void test2() throws IOException, CannotCompileException, InstantiationException, NotFoundException, IllegalAccessException {
        long start = System.currentTimeMillis();
        AbstractEntityHelper studentHelper = HelperFactory.createEntityHelper(Student.class);
        Student s = (Student)studentHelper.create(param);
        System.out.println("time cost1 :  " + (System.currentTimeMillis() - start) + "\n" + s.toString());

        AbstractEntityHelper studentHelper2 = HelperFactory.createEntityHelper(Student.class);
        Student s2 = (Student)studentHelper2.create(param);
        System.out.println("time cost2 :  " + (System.currentTimeMillis() - start) + "\n" + s2.toString());
    }

    private static void test3() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        long start = System.currentTimeMillis();
        Student s = StudentReflectionHelper.create(param);
        System.out.println("time cost3 :  " + (System.currentTimeMillis() - start) + " \n" + s.toString());
    }


}
