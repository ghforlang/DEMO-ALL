package com.edu.nbu.cn.minio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author laoshi . hua
 * @version 1.0 2022/4/25-2:43 PM
 * @since 1.0
 */
@SpringBootApplication
public class MinioApplication {

    public static void main(String[] args) {
        SpringApplication.run(MinioApplication.class,args);
    }

    @RestController
    @RequestMapping("/echo")
    public class EchoController{


        @GetMapping("/hello")
        public String hello(){
            return "echo hello!";
        }
    }
}
