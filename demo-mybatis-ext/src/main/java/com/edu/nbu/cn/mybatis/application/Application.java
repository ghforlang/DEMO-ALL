package com.edu.nbu.cn.mybatis.application;


import com.edu.nbu.cn.mybatis.config.MybatisConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootApplication(scanBasePackages = "com.edu.nbu.cn.mybatis",exclude = {DataSourceAutoConfiguration.class})
@Import(MybatisConfiguration.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
