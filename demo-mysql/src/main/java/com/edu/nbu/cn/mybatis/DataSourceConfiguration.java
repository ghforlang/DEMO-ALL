package com.edu.nbu.cn.mybatis;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author laoshi . hua
 * @version 1.0 2022/11/23-3:29 PM
 * @since 1.0
 */
@Configuration
public class DataSourceConfiguration {

    @Bean
    public DataSource pooledDataSource(){

        PooledDataSource dataSource = new PooledDataSource();
        dataSource.setDriver("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://192.168.3.232:3306/shark_health?useUnicode=true&characterEncoding=utf8&useSSL=false");
        dataSource.setUsername("shark_health");
        dataSource.setPassword("D2YD1KezlkJjvkmqN_WKYmMC");
        dataSource.setPoolPingQuery("SELECT 1");
        return dataSource;
    }

}
