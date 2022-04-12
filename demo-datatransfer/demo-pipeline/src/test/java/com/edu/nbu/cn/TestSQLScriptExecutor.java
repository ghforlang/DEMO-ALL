package com.edu.nbu.cn;

import com.edu.nbu.cn.datatransfer.core.executor.ExecutorRegistry;
import com.edu.nbu.cn.datatransfer.core.executor.InternalExecutorType;
import com.edu.nbu.cn.datatransfer.core.source.DefaultStageResult;
import com.edu.nbu.cn.datatransfer.core.source.SQLScriptStageResource;
import com.edu.nbu.cn.datatransfer.core.source.StageResource;
import com.edu.nbu.cn.datatransfer.core.source.scripts.SQLScript;
import org.junit.Test;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/31-10:53 AM
 * @since 1.0
 */
public class TestSQLScriptExecutor extends BaseTest{

    @Test
    public void testExecute(){
        SQLScript[] sqlScripts = new SQLScript[]{SQLScript.of("people.sql"),SQLScript.of("health_record_peopleatomicinfo_df.sql")};
        StageResource sqlStageResource = new SQLScriptStageResource("mutilSql",sqlScripts);
        ExecutorRegistry.getExecutor(InternalExecutorType.SQL_SCRIPT_EXECUTOR.getName()).execute(sqlStageResource, DefaultStageResult.of("success"));
    }
}
