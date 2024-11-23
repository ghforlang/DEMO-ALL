package com.edu.nbu.cn.lucene;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author laoshi . hua
 * @version 1.0 2023/7/25-2:44 PM
 * @since 1.0
 */
@SpringBootApplication
@MapperScan("com.edu.nbu.cn.lucene.mapper")
public class LuceneDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(LuceneDemoApplication.class,args);
    }
}
