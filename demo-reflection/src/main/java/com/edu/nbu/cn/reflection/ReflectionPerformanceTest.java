package com.edu.nbu.cn.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射性能耗时测试 1ms = 1000000ns
 */
public class ReflectionPerformanceTest {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        long start = System.nanoTime();
        Class<?> clazz = Class.forName("com.edu.nbu.cn.reflection.Student");
        System.out.println("time cost for class.forName() : " + (System.nanoTime() - start));

        start = System.nanoTime();
//        Student s = Student.class.newInstance();
        Student s = (Student)clazz.newInstance();
        System.out.println("time cost for newInstance() : " + (System.nanoTime() - start));

        start = System.nanoTime();
//        Method m = Student.class.getDeclaredMethod("setAge",Integer.class);
        Method m = clazz.getDeclaredMethod("setAge",Integer.class);
        System.out.println("time cost for find method() : " + (System.nanoTime() - start));

        start = System.nanoTime();
        m.invoke(s,10);
        //查看methodAccessor执行过程
        m.invoke(s,"100");
        System.out.println("time cost for find invoke() : " + (System.nanoTime() - start));

        System.out.println(s.getAge());
    }


}
