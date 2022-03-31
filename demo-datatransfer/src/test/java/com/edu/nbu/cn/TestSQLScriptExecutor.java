package com.edu.nbu.cn;

import com.edu.nbu.cn.datatransfer.core.executor.SQLScriptExecutor;
import com.edu.nbu.cn.datatransfer.core.source.DefaultStageResult;
import com.edu.nbu.cn.datatransfer.core.source.SQLScriptStageResource;
import com.edu.nbu.cn.datatransfer.core.source.StageResource;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/31-10:53 AM
 * @since 1.0
 */
public class TestSQLScriptExecutor extends BaseTest{

    @Autowired
    private SQLScriptExecutor sqlScriptExecutor;

    private static String absoluteSqlFilePath ;
    private static final String sqlScriptSqlName = "people.sql";

    static{
        absoluteSqlFilePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    }

    @Test
    public void testExecute(){
        StageResource sqlStageResource = new SQLScriptStageResource("people.sql",absoluteSqlFilePath + sqlScriptSqlName);
        sqlScriptExecutor.execute(sqlStageResource, DefaultStageResult.of("success"));
    }
}
