package com.edu.nbu.cn.data.cleanout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author laoshi . hua
 * @version 1.0 2022/4/6-6:04 PM
 * @since 1.0
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class DataCleanOutApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataCleanOutApplication.class,args);
    }
}
