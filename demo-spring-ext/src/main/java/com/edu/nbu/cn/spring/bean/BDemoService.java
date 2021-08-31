package com.edu.nbu.cn.spring.bean;

import javax.annotation.Resource;

/**
 *
 * @version 1.0
 * @Date 2021/3/11 7:12 下午
 * @since 1.0
 */
public class BDemoService {

    @Resource
    private ADemoService aDemoService;

    public void sayHello(){
        aDemoService.say();
    }

    public  void say(){
        System.out.println("this is b say hello to a!");
    }
}
