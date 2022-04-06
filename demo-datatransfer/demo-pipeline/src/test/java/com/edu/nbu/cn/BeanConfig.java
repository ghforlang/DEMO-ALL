package com.edu.nbu.cn;


import com.edu.nbu.cn.datatransfer.core.executor.SQLScriptExecutor;
import com.edu.nbu.cn.datatransfer.core.mybatis.SQLScriptRunnerWrapper;
import com.edu.nbu.cn.datatransfer.core.pipeline.DefaultPipeline;
import com.edu.nbu.cn.datatransfer.core.pipeline.Pipeline;
import lombok.Builder;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author laoshi . hua
 * @version 1.0 2022/4/2-5:57 PM
 * @since 1.0
 */
@Configuration
public class BeanConfig {

    @Value("${dbTransfer.db.mysqlUrl}")
    private String dbUrl;
    @Value("${dbTransfer.db.mysqlUserName}")
    private String userName;
    @Value("${dbTransfer.db.mysqlPassword}")
    private String password;
    @Value("${dbTransfer.db.mysqlPoolPingQuery}")
    private String poolPingQuery;

    @Bean
    public DataSource dataSource(){
        PooledDataSource dataSource = new PooledDataSource();
        dataSource.setDriver("com.mysql.jdbc.Driver");
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setPoolPingQuery(poolPingQuery);
        return  dataSource;
    }

    @Bean
    public org.apache.ibatis.session.Configuration configuration() {
        Environment environment = new Environment("default", new JdbcTransactionFactory(), dataSource());
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setEnvironment(environment);
        return configuration;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(){
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration());
        return sqlSessionFactory;
    }

    @Bean
    public Connection connection(){
        try {
            return dataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Bean
    public SQLScriptRunnerWrapper sqlScriptRunnerWrapper(){
        return new SQLScriptRunnerWrapper(connection());
    }

    @Bean
    public SQLScriptExecutor sqlScriptExecutor(){
        return new SQLScriptExecutor(sqlScriptRunnerWrapper());
    }

    @Bean
    public Pipeline defaultPipeline(){
        return new DefaultPipeline();
    }
}
