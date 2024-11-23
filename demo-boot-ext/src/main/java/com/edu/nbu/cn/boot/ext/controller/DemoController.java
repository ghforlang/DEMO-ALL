package com.edu.nbu.cn.boot.ext.controller;

import com.edu.nbu.cn.boot.ext.aware.DemoService;
import com.edu.nbu.cn.boot.ext.aware.DemoService1;
import com.edu.nbu.cn.boot.ext.aware.DemoService2;
import com.edu.nbu.cn.boot.ext.beforeshutdown.CustomBeforeShutDownService;
import com.edu.nbu.cn.boot.ext.converter.Person;
import com.edu.nbu.cn.boot.ext.init.CustomInitializeService;
import com.edu.nbu.cn.boot.ext.init.CustomInitializeService2;
import com.edu.nbu.cn.boot.ext.modifybd.model.CustomBean;
import com.edu.nbu.cn.boot.ext.scope.DemoScopeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author laoshi . hua
 * @version 1.0 2023/2/1-10:44 AM
 * @since 1.0
 */
@RestController
@Slf4j
@RequestMapping("/demo/")
public class DemoController {

    @Resource
    private DemoService<DemoController> demoService;
    @Resource
    private DemoService1<DemoController> demoService1;
    @Resource
    private DemoService2<DemoController> demoService2;

    @Resource
    private CustomBean customBean;
    @Resource
    private DemoScopeService demoScopeService;

    @Resource
    private CustomInitializeService customInitializeService;
    @Resource
    private CustomInitializeService2 customInitializeService2;
    @Resource
    private CustomBeforeShutDownService customBeforeShutDownService;

    @GetMapping("intercept")
    public String hello(String name){
        return "hi," + name + ",you have been intercepted!";
    }

    @GetMapping("aware")
    public void aware(){
        log.info(demoService.getBean("demoController").toString());
        log.info(demoService1.getBean("demoController").toString());
        log.info(demoService2.getBean("demoController").toString());
    }

    @GetMapping("exception")
    public void exception(String type){
        if(type.equalsIgnoreCase("1")){
            throw new NullPointerException("空指针异常!");
        }else if(type.equalsIgnoreCase("2")){
            throw new ArrayIndexOutOfBoundsException("数组越界异常!");
        }else if(type.equalsIgnoreCase("3")){
            throw new ArithmeticException("算数运算异常!");
        }else if(type.equalsIgnoreCase("4")){
            throw new NumberFormatException("数字格式化异常!");
        }else{
            throw new RuntimeException("运行时异常!");
        }
    }

    @GetMapping("convertParam")
    public void convertParam(@RequestParam("date") Date date){
        log.info("convertParam {}",date);
    }

    @PostMapping(value = "convert")
    public void save(@RequestBody Person person){
        log.info("person.name:{}",person.getName());
        log.info("person.age:{}",person.getAge());
        log.info("person.birthday:{}",person.getBirthday());
    }

    @GetMapping("/registrarBean")
    public void registrarBean(){
        log.info("customBean.beanName:{}",customBean.getBeanName());
        log.info("customBean.beanContent:{}",customBean.getBeanContent());
    }

    @GetMapping("initializing")
    public void initializing(){
        customInitializeService.test();
        customInitializeService2.test();
    }

    @GetMapping("/shutDown")
    public void shutDown(){
        customBeforeShutDownService.shutDown();
    }

    @GetMapping("/scope")
    public void scopeService(){
        demoScopeService.scopeService();
    }
}
