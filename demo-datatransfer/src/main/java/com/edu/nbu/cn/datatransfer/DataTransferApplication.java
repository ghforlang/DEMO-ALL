package com.edu.nbu.cn.datatransfer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/18-2:13 下午
 * @since 1.0
 */
@SpringBootApplication
@EnableConfigurationProperties
public class DataTransferApplication {


    public static void main(String[] args) {
        SpringApplication.run(DataTransferApplication.class,args);

    }
}
