package com.edu.nbu.cn.mybatis.config;


import com.edu.nbu.cn.mybatis.interceptor.ForbidWriteInterceptor;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class MybatisConfiguration {

    @Value("${dbType}")
    private String dbType = "mysql";

    @Bean
    public DataSource pooledDataSource(){

        PooledDataSource dataSource = new PooledDataSource();
        dataSource.setDriver("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/TTT?useUnicode=true&characterEncoding=utf8&autoReconnect=true&allowMultiQueries=true&serverTimezone=GMT%2B8");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        dataSource.setPoolPingQuery("SELECT 1");
        return dataSource;
    }

    @Bean
    public DataSource pooledDataSource2(){

        PooledDataSource dataSource = new PooledDataSource();
        dataSource.setDriver("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://192.168.3.99:5836/test_fanwh");
        dataSource.setUsername("postgres");
        dataSource.setPassword("ewq49_gIpLIA5G6BuzGKa7tV");
        dataSource.setPoolPingQuery("SELECT 1");
        return dataSource;
    }

    @Bean
    public org.apache.ibatis.session.Configuration configuration(){
        DataSource ds = null;
        switch (dbType){
            case "mysql": ds = pooledDataSource();
            break;
            case "postgresl": ds = pooledDataSource2();
            break;
            default: ds = pooledDataSource();
        }

        Environment environment = new Environment("default", new JdbcTransactionFactory(), ds);
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setEnvironment(environment);
        configuration.addMappers("com.edu.nbu.cn.mybatis.mapper");
//        configuration.addLoadedResource("classpath*:/mapper/*.xml");
//        configuration.addInterceptor(new ForbidWriteInterceptor());
        XMLMapperBuilder xmlMapperBuilder = new XMLMapperBuilder(this.getClass().getResourceAsStream("/mapper/BasicHealthInfoMapper.xml"), configuration, "mapper/BasicHealthInfoMapper.xml", configuration.getSqlFragments());
        xmlMapperBuilder.parse();
        return configuration;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(){
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration());
        return sqlSessionFactory;
    }
}
