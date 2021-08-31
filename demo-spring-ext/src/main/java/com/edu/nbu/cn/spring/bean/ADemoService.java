package com.edu.nbu.cn.spring.bean;

import javax.annotation.Resource;

/**
 *
 * @version 1.0
 * @Date 2021/3/11 7:12 下午
 * @since 1.0
 */
public class ADemoService {

    @Resource
    private BDemoService bDemoService;


    public  void sayHello(){
        bDemoService.say();
    }

    public void say(){
        System.out.println("this is a say hello to b!");
    }

//    public void setbDemoService(BDemoService bDemoService) {
//        this.bDemoService = bDemoService;
//    }
}
