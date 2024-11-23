package com.edu.nbu.cn.classloader.demo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author laoshi . hua
 * @version 1.0 2023/7/27-5:32 PM
 * @since 1.0
 *  ----------------------------------- classLoader执行顺序 -----------------------------------------
 * loadClass ---步骤中双亲委派模式生效
 * ->findClass -- 双亲加载失败，则开始findClass
 * ->defineClass (preDefineClass -> defineClassSourceLocation ->defineClass1 -> postDefineClass) ->)
 *  类加载传导规则：JVM 会选择当前类的类加载器来加载所有该类的引用的类;所以testMyClassLoaderForLoadClass输出类加载器相同
 */
public class ClassLoaderAll {
    /**
     *
     * @param args
     * @throws ClassNotFoundException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     */
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
          // 采用JDK默认类加载器加载
          testJDKClassLoader();
          // 显式指定自定义加载器find
          testMyClassLoaderForFindClass();
          // 显式指定自定义加载器load加载
          testMyClassLoaderForLoadClass();
    }

    private static void testJDKClassLoader() {
        TestA testA = new TestA();
        testA.hello();
    }

    private static void testMyClassLoaderForLoadClass() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        MyClassLoaderForLoadClass myClassLoader = new MyClassLoaderForLoadClass(ClassLoaderAll.class.getClassLoader());
        Class<?> testAClazz = myClassLoader.loadClass("com.edu.nbu.cn.classloader.demo.testA");
        Method mainMethod = testAClazz.getDeclaredMethod("main",String[].class);
        mainMethod.invoke(null,new Object[] {null});
    }

    private static void testMyClassLoaderForFindClass() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        MyClassLoaderForFindClass myClassLoader = new MyClassLoaderForFindClass();
        Class<?> testAClazz = myClassLoader.findClass("com.edu.nbu.cn.classloader.demo.testA");
        Method mainMethod = testAClazz.getDeclaredMethod("main",String[].class);
        mainMethod.invoke(null,new Object[]{null});
    }
}
