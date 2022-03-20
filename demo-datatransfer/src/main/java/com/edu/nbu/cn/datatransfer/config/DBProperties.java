package com.edu.nbu.cn.datatransfer.config;

import com.edu.nbu.cn.datatransfer.contants.DialectEnum;
import com.edu.nbu.cn.datatransfer.model.db.DBConnectionInfo;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.HashMap;
import java.util.Map;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/18-3:07 下午
 * @since 1.0
 */
@ConfigurationProperties(prefix = "transfer.db")
@Validated
@Component
@Getter
@Setter
public class DBProperties implements InitializingBean {

    private final Map<String, DBConnectionInfo> dbConnectionMap = new HashMap<>();

    // @Value("${dialect}")
    private String dialectToUse;

    // @Value("${mysql.url}")
    private String mysqlUrl;
    // @Value("${mysql.username}")
    private String mysqlUserName;
    // @Value("${mysql.password}")
    private String mysqlPassword;
    // @Value("${mysql.poolPingQuery}")
    private String mysqlPoolPingQuery;


    // @Value("${postgresql.url}")
    private String postgresqlUrl;
    // @Value("${postgresql.username}")
    private String postgresqlUserName;
    // @Value("${postgresql.password}")
    private String postgresqlPassword;
    // @Value("${postgresql.poolPingQuery}")
    private String postgresqlPoolPingQuery;


    @Override
    public void afterPropertiesSet() throws Exception {
        if(StringUtils.isNoneBlank(mysqlUrl,mysqlPassword,mysqlUserName,mysqlPoolPingQuery)){
            DBConnectionInfo connectionInfo = DBConnectionInfo.builder()
                    .url(mysqlUrl)
                    .userName(mysqlUserName)
                    .password(mysqlPassword)
                    .poolPingQuery(mysqlPoolPingQuery)
                    .build();
            dbConnectionMap.putIfAbsent(DialectEnum.Mysql.getDialect(),connectionInfo);
        }
        if(StringUtils.isNoneBlank(postgresqlUrl,postgresqlPassword,postgresqlUserName,postgresqlPoolPingQuery)){
            DBConnectionInfo connectionInfo = DBConnectionInfo.builder()
                    .url(postgresqlUrl)
                    .userName(postgresqlUserName)
                    .password(postgresqlPassword)
                    .poolPingQuery(postgresqlPoolPingQuery)
                    .build();
            dbConnectionMap.putIfAbsent(DialectEnum.Postgresql.getDialect(),connectionInfo);
        }
    }

    public DBConnectionInfo getDBConnectionInfo(){
        return dbConnectionMap.get(dialectToUse);
    }
}
