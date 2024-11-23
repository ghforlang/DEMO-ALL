package com.edu.nbu.cn.bytebuddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.pool.TypePool;

/**
 * @author laoshi . hua
 * @version 1.0 2023/7/28-2:33 PM
 * @since 1.0
 * 为java提供使用Unloaded类的能力，
 */
public class TypePoolDemo {
    public static void main(String[] args) throws NoSuchFieldException {
        testOne();
    }

    public static void testOne() throws NoSuchFieldException {
        TypePool typePool = TypePool.Default.ofSystemLoader();
        Class clazz = new ByteBuddy()
                .redefine(typePool.describe("com.edu.nbu.cn.bytebuddy.model.Foo").resolve(), ClassFileLocator.ForClassLoader.ofSystemLoader())
                .defineField("queue",String.class)
                .make()
                .load(ClassLoader.getSystemClassLoader(), ClassLoadingStrategy.Default.INJECTION)
                .getLoaded();
        System.out.println(clazz.getDeclaredField("queue"));
    }
}
