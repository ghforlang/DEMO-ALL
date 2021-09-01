package com.edu.nbu.cn.mybatis.config;


import com.edu.nbu.cn.mybatis.interceptor.ForbidWriteInterceptor;
import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class MybatisConfiguration {
    @Bean
    public DataSource pooledDataSource(){

        PooledDataSource dataSource = new PooledDataSource();
        dataSource.setDriver("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/employees?useUnicode=true&characterEncoding=utf8&autoReconnect=true&allowMultiQueries=true&serverTimezone=GMT%2B8");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        dataSource.setPoolPingQuery("SELECT 1");
        return dataSource;
    }


    @Bean
    public org.apache.ibatis.session.Configuration configuration(){
        Environment environment = new Environment("default", new JdbcTransactionFactory(), pooledDataSource());
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setEnvironment(environment);
        configuration.addMappers("com.edu.nbu.cn.mybatis.mapper");
//        configuration.addLoadedResource("classpath*:/mapper/EmployeesMapper.xml");
        configuration.addInterceptor(new ForbidWriteInterceptor());
        XMLMapperBuilder xmlMapperBuilder = new XMLMapperBuilder(this.getClass().getResourceAsStream("/mapper/EmployeesMapper.xml"), configuration, "mapper/EmployeesMapper.xml", configuration.getSqlFragments());
        xmlMapperBuilder.parse();
        return configuration;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(){
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration());
        return sqlSessionFactory;
    }
}
