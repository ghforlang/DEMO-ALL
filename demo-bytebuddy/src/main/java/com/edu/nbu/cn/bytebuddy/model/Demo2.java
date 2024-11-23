package com.edu.nbu.cn.bytebuddy.model;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.MethodDelegation;

import static net.bytebuddy.matcher.ElementMatchers.*;

/**
 * @author laoshi . hua
 * @version 1.0 2023/7/27-2:20 PM
 * @since 1.0
 */
public class Demo2 {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        test1();
//        test2();
    }

    public static  void test1() throws InstantiationException, IllegalAccessException {
        String result = new ByteBuddy().subclass(Foo.class)
                .method(named("sayFoo")
                        .and(isDeclaredBy(Foo.class))
                        .and(returns(String.class)))
                .intercept(MethodDelegation.to(Bar.class))
                .make()
                .load(Demo2.class.getClassLoader())
                .getLoaded()
                .newInstance()
                .sayFoo();
        System.out.println("test1 result ：" + result);
    }

    public static void test2() throws InstantiationException, IllegalAccessException {
        String result = new ByteBuddy().subclass(Foo.class)
                .method(named("sayFoo")
                        .and(isDeclaredBy(Foo.class))
                        .and(returns(String.class)))
                .intercept(MethodDelegation.to(new Bar()))
                .make()
                .load(Demo2.class.getClassLoader())
                .getLoaded()
                .newInstance()
                .sayFoo();
        System.out.println("test2 result ：" + result);
    }
}
