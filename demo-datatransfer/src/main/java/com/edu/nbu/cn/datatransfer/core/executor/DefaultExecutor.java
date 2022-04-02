package com.edu.nbu.cn.datatransfer.core.executor;


import com.edu.nbu.cn.datatransfer.core.source.StageResource;
import com.edu.nbu.cn.datatransfer.core.source.StageResult;
import lombok.extern.slf4j.Slf4j;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/28-1:41 下午
 * @since 1.0
 */
@Slf4j
public class DefaultExecutor extends AbstractExecutor<String> {


    public DefaultExecutor() {
        log.info("register to executorRegistry,executor[" + this.name() + "]");
        ExecutorRegistry.registerExecutor(this);
    }

    @Override
    public void execute(StageResource stageResource, StageResult previousStageResult) {
        super.execute(stageResource,previousStageResult);
    }

    @Override
    public StageResult<String> executeWithReturn(StageResource stageResource,StageResult previousStageResult) {
        return super.executeWithReturn(stageResource,previousStageResult);
    }


    @Override
    public String name() {
        return InternalExecutorType.DEFAULT_EXECUTOR.getName();
    }
}
