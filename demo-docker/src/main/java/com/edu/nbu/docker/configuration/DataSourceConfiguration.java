package com.edu.nbu.docker.configuration;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author laoshi . hua
 * @version 1.0 2024/7/10-19:37
 * @since 1.0
 */
//@Configuration
public class DataSourceConfiguration {


    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Bean
    public DataSource pooledDataSource(){
        PooledDataSource dataSource = new PooledDataSource();
        dataSource.setDriver(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setPoolPingQuery("SELECT 1");
        return dataSource;
    }
}
