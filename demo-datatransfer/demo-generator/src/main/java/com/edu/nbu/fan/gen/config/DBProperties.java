package com.edu.nbu.fan.gen.config;


import com.alibaba.fastjson.JSON;
import com.edu.nbu.fan.gen.contants.DialectEnum;
import com.edu.nbu.fan.gen.metainfo.db.DBConnectionInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/18-3:07 下午
 * @since 1.0
 */
@ConfigurationProperties(prefix = "db2pojo.db")
@Validated
@Component
@Getter
@Setter
@Slf4j
public class DBProperties implements InitializingBean {

    private final Map<String, DBConnectionInfo> dbConnectionMap = new HashMap<>();
    /**
     * 源表->目标表map，结构 源表 -> List<源表，目标表>
     */
    private final Map<String,List<ImmutablePair<String,String>>> srcTarTableNamePairs = new HashMap<>();
    /**
     * 目标表->源表map，结构 目标表 -> List<目标表,源表>
     */
    private final Map<String,List<ImmutablePair<String,String>>> tarSrcTableNamePairs = new HashMap();

    // @Value("${dialect}")
    private String dialectToUse;

    private List<String> sourceTargetTablePairs;

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

    @Value("${db2pojo.pojo.dir}")
    private String pojoDir;


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

        if(CollectionUtils.isNotEmpty(sourceTargetTablePairs)){
            for (String sourceTargetTablePair : sourceTargetTablePairs) {
                String[] tempPairs = StringUtils.split(sourceTargetTablePair,"#");
                if(tempPairs.length == 2){
                    if(StringUtils.isNotBlank(tempPairs[1])){
                        String[] tarTables = StringUtils.split(tempPairs[1],"|");
                        srcTarTableNamePairs.putIfAbsent(tempPairs[0],new ArrayList<>());
                        for(int i=0;i<tarTables.length;i++){
                            srcTarTableNamePairs.get(tempPairs[0]).add(new ImmutablePair<>(tempPairs[0],tarTables[i]));
                            tarSrcTableNamePairs.putIfAbsent(tarTables[i],new ArrayList<>());
                            tarSrcTableNamePairs.get(tarTables[i]).add(new ImmutablePair<>(tarTables[i],tempPairs[0]));
                        }
                    }
                }
            }
            log.debug("srcTarTableNamePairs:" + JSON.toJSONString(srcTarTableNamePairs));
            log.debug("tarSrcTableNamePairs:" + JSON.toJSONString(tarSrcTableNamePairs));
        }
    }

    public DBConnectionInfo getDBConnectionInfo(){
        return dbConnectionMap.get(dialectToUse);
    }
}
