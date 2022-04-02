package com.edu.nbu.cn.datatransfer.core.executor;

import com.edu.nbu.cn.datatransfer.core.source.DefaultStageResult;
import com.edu.nbu.cn.datatransfer.core.source.StageResource;
import com.edu.nbu.cn.datatransfer.core.source.StageResult;
import lombok.extern.slf4j.Slf4j;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/31-3:43 PM
 * @since 1.0
 */
@Slf4j
public class PreparedExecutor extends  AbstractExecutor<String>{

    public PreparedExecutor() {
        log.debug("register to executorRegistry,executor[" + this.name() + "]");
        ExecutorRegistry.registerExecutor(this);
    }

    @Override
    public void execute(StageResource stageResource, StageResult previousStageResult) {
        super.execute(stageResource,previousStageResult);
        // do something to prepare
        log.info("all operations has been prepared!");
    }

    @Override
    public StageResult<String> executeWithReturn(StageResource stageResource,StageResult previousStageResult) {
        super.executeWithReturn(stageResource,previousStageResult);
        // do something to prepare
        return DefaultStageResult.of("success!");
    }

    @Override
    public String name() {
        return InternalExecutorType.PREPARED_EXECUTOR.getName();
    }

}
