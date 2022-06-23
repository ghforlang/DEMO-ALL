package com.edu.nbu.cn.spring;


import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @version 1.0
 * @Date 2021/3/11 7:28 下午
 * @since 1.0
 */
public class SpringApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-beans.xml");
//        BDemoService bDemoService = (BDemoService) context.getBean("bDemoService");
//        bDemoService.sayHello();
//
//        ADemoService aDemoService = (ADemoService) context.getBean("aDemoService");
//        aDemoService.sayHello();
//
//        BDemoService bDemoService1 = (BDemoService) context.getBean("bDemoService");
//        bDemoService1.sayHello();


    }
}
