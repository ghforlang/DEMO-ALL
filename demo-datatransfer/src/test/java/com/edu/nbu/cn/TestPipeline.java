package com.edu.nbu.cn;

import com.edu.nbu.cn.datatransfer.core.executor.CodeGeneratorExecutor;
import com.edu.nbu.cn.datatransfer.core.executor.DefaultExecutor;
import com.edu.nbu.cn.datatransfer.core.executor.ExecutorSupport;
import com.edu.nbu.cn.datatransfer.core.executor.InternalExecutorType;
import com.edu.nbu.cn.datatransfer.core.executor.SQLScriptExecutor;
import com.edu.nbu.cn.datatransfer.core.pipeline.DefaultStage;
import com.edu.nbu.cn.datatransfer.core.pipeline.InternalStageType;
import com.edu.nbu.cn.datatransfer.core.pipeline.Pipeline;
import com.edu.nbu.cn.datatransfer.core.pipeline.Stage;
import com.edu.nbu.cn.datatransfer.core.source.DefaultStageResult;
import com.edu.nbu.cn.datatransfer.core.source.SQLScriptStageResource;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/31-10:51 AM
 * @since 1.0
 */
public class TestPipeline extends BaseTest{

    @Autowired
    private Pipeline defaultPipeline;
    @Autowired
    private ExecutorSupport executorSupport;

    @Test
    public void testPipeline(){

        DefaultStage preparedStage = InternalStageType.PREPARED.getStage();
        preparedStage.setExecutor(executorSupport.getExecutor(InternalExecutorType.PREPARED_EXECUTOR.getName()));

        DefaultStage codeGeneratorStage = InternalStageType.CODE_GENERATOR.getStage();
        codeGeneratorStage.setExecutor(executorSupport.getExecutor(InternalExecutorType.CODE_GENERATOR_EXECUTOR.getName()));
        codeGeneratorStage.setOrder(10);

        DefaultStage sqlExecuteStage =InternalStageType.SQL_SCRIPT.getStage();
        sqlExecuteStage.setExecutor(executorSupport.getExecutor(InternalExecutorType.SQL_SCRIPT_EXECUTOR.getName()));
        sqlExecuteStage.setOrder(20);
        String sqlFileName = "people.sql";
        SQLScriptStageResource stageResource = new SQLScriptStageResource(sqlFileName,Thread.currentThread().getContextClassLoader().getResource("").getPath() + sqlFileName);
        sqlExecuteStage.setStageResource(stageResource);

        // 装配stages
        defaultPipeline.plugin(new Stage[]{preparedStage,codeGeneratorStage,sqlExecuteStage});
        // 执行stages
        defaultPipeline.execute();
    }
}
