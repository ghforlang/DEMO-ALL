package com.edu.nbu.docker;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author laoshi . hua
 * @version 1.0 2024/7/3-07:32
 * @since 1.0
 */
@SpringBootApplication
//@MapperScan(value = "com.edu.nbu.docker.mapper")
public class DockerApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication();
        springApplication.run(DockerApplication.class,args);
    }

}
