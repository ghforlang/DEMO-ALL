package com.edu.nbu.cn.boot.ext;

import com.edu.nbu.cn.boot.ext.all.DemoApplicationContextInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author laoshi . huao
 * @version 1.0 2023/2/1-10:50 AM
 * @since 1.0
 */
@SpringBootApplication
public class BootExtApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication();
        springApplication.addInitializers(new DemoApplicationContextInitializer());
        springApplication.run(BootExtApplication.class,args);

    }
}