package com.edu.nbu.cn.datatransfer.core.source;

import org.apache.poi.ss.formula.functions.T;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/28-1:41 下午
 * @since 1.0
 */
public class DefaultExecutor extends AbstractExecutor{
    private String executorName = "defaultExecutor";

    @Override
    public void execute(StageResource stageResource) {
        super.execute(stageResource);
    }

    @Override
    public StageResult<T> executeWithReturn(StageResource stageResource) {
        return super.executeWithReturn(stageResource);
    }


    @Override
    public String name() {
        return executorName;
    }
}
