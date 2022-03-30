package com.edu.nbu.cn.datatransfer.core.executor;


import com.edu.nbu.cn.datatransfer.core.executor.AbstractExecutor;
import com.edu.nbu.cn.datatransfer.core.source.StageResource;
import com.edu.nbu.cn.datatransfer.core.source.StageResult;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/28-1:41 下午
 * @since 1.0
 */
public class DefaultExecutor extends AbstractExecutor<String> {
    private String executorName = "defaultExecutor";

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
        return executorName;
    }
}
