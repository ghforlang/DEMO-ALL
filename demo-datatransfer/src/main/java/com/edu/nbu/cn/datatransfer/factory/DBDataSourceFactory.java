package com.edu.nbu.cn.datatransfer.factory;

import com.edu.nbu.cn.datatransfer.config.DBProperties;
import com.edu.nbu.cn.datatransfer.contants.DialectEnum;
import com.edu.nbu.cn.datatransfer.exception.DBConnectionException;
import com.edu.nbu.cn.datatransfer.model.db.DBConnectionInfo;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Objects;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/18-3:41 下午
 * @since 1.0
 */
@Component
public class DBDataSourceFactory{

    @Autowired
    private DBProperties dbProperties;

    public DataSource getDataSource(DialectEnum dialect) throws DBConnectionException {
        DBConnectionInfo connectionInfo = dbProperties.getDbConnectionMap().get(dialect.getDialect());
        if(Objects.isNull(connectionInfo)){
            throw new DBConnectionException("can not find useful DBConnection info!");
        }

        PooledDataSource dataSource = new PooledDataSource();
        dataSource.setDriver(dialect.getDriverClassName());
        dataSource.setUrl(connectionInfo.getUrl());
        dataSource.setUsername(connectionInfo.getUserName());
        dataSource.setPassword(connectionInfo.getPassword());
        dataSource.setPoolPingQuery(connectionInfo.getPoolPingQuery());
        return dataSource;
    }
}
