package com.edu.nbu.cn.datatransfer.core.executor;

import com.edu.nbu.cn.datatransfer.core.source.DefaultStageResult;
import com.edu.nbu.cn.datatransfer.core.source.SQLScriptStageResource;
import com.edu.nbu.cn.datatransfer.core.source.StageResource;
import com.edu.nbu.cn.datatransfer.core.source.StageResult;
import com.edu.nbu.cn.datatransfer.core.mybatis.SQLScriptRunnerWrapper;
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
            String sqlFileName = ((SQLScriptStageResource) stageResource).getOriginalSqlFileName();
            try {
                // 默认使用绝对路径
                sqlScriptRunnerWrapper.executeSQLScript(new File(sqlFileName),true);
                logger.debug("executing sqlScript [" + sqlFileName + "] success!");
            } catch (IOException e) {
                logger.error("executing sqlScript [" + sqlFileName + "] failed!");
                e.printStackTrace();
            }
        }else{
            throw new UnsupportedOperationException("operation is not supported!");
        }
    }
}
