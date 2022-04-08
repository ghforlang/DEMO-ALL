package com.edu.nbu.cn.datatransfer.core.executor;

import com.edu.nbu.cn.datatransfer.core.source.DefaultStageResult;
import com.edu.nbu.cn.datatransfer.core.source.SQLScriptStageResource;
import com.edu.nbu.cn.datatransfer.core.source.StageResource;
import com.edu.nbu.cn.datatransfer.core.source.StageResult;
import com.edu.nbu.cn.datatransfer.core.mybatis.SQLScriptRunnerWrapper;
import com.edu.nbu.cn.datatransfer.core.source.scripts.SQLScript;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/25-4:08 下午
 * @since 1.0
 */
@Slf4j
public class SQLScriptExecutor extends AbstractExecutor<String> {

    private SQLScriptRunnerWrapper sqlScriptRunnerWrapper;

    public SQLScriptExecutor(SQLScriptRunnerWrapper sqlScriptRunnerWrapper) {
        this.sqlScriptRunnerWrapper = sqlScriptRunnerWrapper;
        logger.info("register to executorRegistry,executor[" + this.name() + "]");
        ExecutorRegistry.registerExecutor(this);
    }

    @Override
    public void execute(StageResource stageResource, StageResult stageResult) {
        super.execute(stageResource,null);
        commonExecute(stageResource);
    }

    @Override
    public StageResult<String> executeWithReturn(StageResource stageResource, StageResult stageResult) {
        super.executeWithReturn(stageResource, stageResult);
        commonExecute(stageResource);
        return DefaultStageResult.of("successful!");
    }

    @Override
    public String name() {
        return InternalExecutorType.SQL_SCRIPT_EXECUTOR.getName();
    }


    private void commonExecute(StageResource stageResource){
        if(stageResource instanceof SQLScriptStageResource){
            SQLScript[] sqlScripts = (SQLScript[]) ((SQLScriptStageResource) stageResource).getScripts();
            for(SQLScript script : sqlScripts){
                try{
                    sqlScriptRunnerWrapper.executeSQLScript(new File(script.filePath()),script.absolutePath());
                    logger.debug("executing sqlScript [" + script.filePath() + "] success!");
                } catch (IOException e) {
                    logger.error("executing sqlScript [" + script.filePath() + "] failed!");
                    e.printStackTrace();
                }
            }
        }else{
            throw new UnsupportedOperationException("operation is not supported!");
        }
    }
}
