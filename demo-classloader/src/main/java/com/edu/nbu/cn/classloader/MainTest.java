package com.edu.nbu.cn.classloader;

import java.util.concurrent.TimeUnit;

/**
 *
 * @version 1.0
 * @Date 2021/1/29 11:49 上午
 * @since 1.0
 */
public class MainTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InterruptedException {
        while (true){
            MyClassLoader cl = new MyClassLoader();
            Class<?> clazz = cl.loadClass("com.edu.nbu.cn.classloader.TestCl");
            TestCl tcl = (TestCl) clazz.newInstance();
            tcl.testDemo();
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
