package com.edu.nbu.cn.datatransfer.config;

import com.edu.nbu.cn.datatransfer.contants.DialectEnum;
import com.edu.nbu.cn.datatransfer.exception.DBConnectionException;
import com.edu.nbu.cn.datatransfer.factory.DBDataSourceFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/18-2:27 下午
 * @since 1.0
 */
@Configuration
@Slf4j
public class DBConfig {

    @Autowired
    private DBProperties dbProperties;
    @Autowired
    private DBDataSourceFactory dbDataSourceFactory;

    @Bean
    public DataSource dataSource() throws DBConnectionException {
        return defineDataSource();
    }

    @Bean
    public org.apache.ibatis.session.Configuration configuration() throws DBConnectionException {
        Environment environment = new Environment("default", new JdbcTransactionFactory(), dataSource());
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setEnvironment(environment);
//        configuration.addMappers("com.edu.nbu.cn.mybatis.mapper");
//        configuration.addLoadedResource("classpath*:/mapper/*.xml");
//        configuration.addInterceptor(new ForbidWriteInterceptor());
//        XMLMapperBuilder xmlMapperBuilder = new XMLMapperBuilder(this.getClass().getResourceAsStream("/mapper/BasicHealthInfoMapper.xml"), configuration, "mapper/BasicHealthInfoMapper.xml", configuration.getSqlFragments());
//        xmlMapperBuilder.parse();
        return configuration;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws DBConnectionException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration());
        return sqlSessionFactory;
    }


    @Bean
    public Connection sqlConnection(){
        try {
            return defineDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            log.error("fecth connection failed!");
        }
        return null;
    }
    private DataSource defineDataSource() throws DBConnectionException {
        if(StringUtils.isBlank(dbProperties.getDialectToUse())){
            throw new DBConnectionException("choose one dialect at least!");
        }
        DialectEnum dialect = DialectEnum.getByDialect(dbProperties.getDialectToUse());
        return dbDataSourceFactory.getDataSource(dialect);
    }
}
