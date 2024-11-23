package com.edu.nbu.cn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author laoshi . hua
 * @version 1.0 2022/11/23-3:33 PM
 * @since 1.0
 */
@RestController
@RequestMapping("/test")
public class TestController {

//    @Autowired
//    private

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
