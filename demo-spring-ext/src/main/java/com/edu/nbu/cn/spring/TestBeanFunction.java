package com.edu.nbu.cn.spring;

import com.edu.nbu.cn.spring.executor.DemoExecutor;
import com.edu.nbu.cn.spring.factory.FactoryHolder;
import com.edu.nbu.cn.spring.factory.FunctionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author laoshi . hua
 * @version 1.0 2022/6/22-5:36 PM
 * @since 1.0
 */
public class TestBeanFunction {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext("com.edu.nbu.cn.spring");
//        AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(FunctionBeanConfiguration.class);
        FunctionFactory factory = FactoryHolder.getInstance().get();
        factory.get(DemoExecutor.class).apply("a");
        factory.get(DemoExecutor.class).apply("b");
    }
}
