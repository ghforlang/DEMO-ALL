package com.edu.nbu.cn;

import com.edu.nbu.cn.mybatis.DataSourceConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;

/**
 * @author laoshi . hua
 * @version 1.0 2022/11/23-3:27 PM
 * @since 1.0
 */
@SpringBootApplication(scanBasePackages = "com.edu.nbu.cn.mybatis",exclude = {DataSourceAutoConfiguration.class})
@Import(DataSourceConfiguration.class)
public class MySqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySqlApplication.class,args);
    }
}
