package com.edu.nbu.cn;

import com.edu.nbu.cn.datatransfer.core.executor.CodeGeneratorExecutor;
import com.edu.nbu.cn.datatransfer.core.executor.ExecutorRegistry;
import com.edu.nbu.cn.datatransfer.core.executor.InternalExecutorType;
import com.edu.nbu.cn.datatransfer.core.executor.JarFileExecutor;
import com.edu.nbu.cn.datatransfer.core.executor.PreparedExecutor;
import com.edu.nbu.cn.datatransfer.core.pipeline.DefaultStage;
import com.edu.nbu.cn.datatransfer.core.pipeline.InternalStageType;
import com.edu.nbu.cn.datatransfer.core.pipeline.Pipeline;
import com.edu.nbu.cn.datatransfer.core.pipeline.Stage;
import com.edu.nbu.cn.datatransfer.core.source.JARStageResource;
import com.edu.nbu.cn.datatransfer.core.source.SQLScriptStageResource;
import com.edu.nbu.cn.datatransfer.core.source.scripts.SQLScript;
import org.junit.Before;
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

    private static final String jarFileName = "demo-spel-1.0-SNAPSHOT.jar";
    private static final String codeGenarateFileName = "demo-db2pojo-1.0.0.jar";

    @Before
    public void initExecutor(){
        new PreparedExecutor();
        new CodeGeneratorExecutor();
        new JarFileExecutor();
    }

    @Test
    public void testPipeline(){

        DefaultStage preparedStage = InternalStageType.PREPARED.getStage();
        preparedStage.setExecutor(ExecutorRegistry.getExecutor(InternalExecutorType.PREPARED_EXECUTOR.getName()));

        DefaultStage codeGeneratorStage = InternalStageType.CODE_GENERATOR.getStage();
        codeGeneratorStage.setExecutor(ExecutorRegistry.getExecutor(InternalExecutorType.CODE_GENERATOR_EXECUTOR.getName()));
        JARStageResource codeGeneratorStageResource = new JARStageResource(codeGenarateFileName,Thread.currentThread().getContextClassLoader().getResource("").getPath() + codeGenarateFileName);
        codeGeneratorStage.setStageResource(codeGeneratorStageResource);
        codeGeneratorStage.setOrder(10);

        DefaultStage sqlExecuteStage =InternalStageType.SQL_SCRIPT.getStage();
        sqlExecuteStage.setExecutor(ExecutorRegistry.getExecutor(InternalExecutorType.SQL_SCRIPT_EXECUTOR.getName()));
        sqlExecuteStage.setOrder(20);
        String sqlFileName = "people.sql";
        SQLScript[] sqlScripts = new SQLScript[]{SQLScript.of(sqlFileName)};
        SQLScriptStageResource stageResource = new SQLScriptStageResource("singleSql",sqlScripts);
        sqlExecuteStage.setStageResource(stageResource);

        DefaultStage jarExecuteStage = InternalStageType.JAR_FILE.getStage();
        jarExecuteStage.setExecutor(ExecutorRegistry.getExecutor(InternalExecutorType.JAR_FILE_EXECUTOR.getName()));
        jarExecuteStage.setOrder(30);
        JARStageResource jarStageResource = new JARStageResource(jarFileName,Thread.currentThread().getContextClassLoader().getResource("").getPath() + jarFileName);
        jarExecuteStage.setStageResource(jarStageResource);

        // 装配stages
        defaultPipeline.plugin(new Stage[]{preparedStage,codeGeneratorStage,jarExecuteStage});
        // 执行stages
        defaultPipeline.execute();
    }
}
