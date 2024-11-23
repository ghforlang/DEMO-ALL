package com.edu.nbu.cn.mybatis.interceptor;


import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Objects;
import java.util.Properties;

@Intercepts({
        @Signature(type = StatementHandler.class, method = "update", args = {Statement.class})
})
public class ForbidWriteInterceptor implements Interceptor {
    private Properties properties;
    private static final Logger LOGGER = LoggerFactory.getLogger(ForbidWriteInterceptor.class);

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        PreparedStatement ps = (PreparedStatement)invocation.getArgs()[0];
        if(Objects.nonNull(ps)){
            String rawSql = ps.getConnection().getMetaData().getURL();
//            String rawSql = ps.toString();
//            int updateIndex = rawSql.indexOf("update") == -1 ? rawSql.indexOf("insert") : -1;
//            // 非更新语句，直接执行
//            if(updateIndex == -1 ){
//                return invocation.proceed();
//            }
//            rawSql = rawSql.substring(updateIndex);
            LOGGER.info("row sql : " + rawSql);
        }
        return 1;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target,this);
    }

    @Override
    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
