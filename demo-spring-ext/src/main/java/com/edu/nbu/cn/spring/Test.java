package com.edu.nbu.cn.spring;

import com.edu.nbu.cn.spring.registrar.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;


/**
 *
 * @version 1.0
 * @Date 2021/2/3 11:59 上午
 * @since 1.0
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Configuration.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames).forEach(name -> System.out.println(name));
    }
}
