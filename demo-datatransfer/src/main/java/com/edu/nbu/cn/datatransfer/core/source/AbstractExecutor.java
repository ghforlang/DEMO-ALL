package com.edu.nbu.cn.datatransfer.core.source;

import org.apache.poi.ss.formula.functions.T;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/25-3:47 下午
 * @since 1.0
 */
public abstract class AbstractExecutor implements Executor<T> {

    @Override
    public void execute(StageResource stageResource) {
        if(stageResource.hasResult()){
            System.out.println("Resource need return result,please use executeWithReturn [" + stageResource.sourceName() + "]");
        }
        System.out.println("execute Resource [" + stageResource.sourceName() + "]");
    }

    @Override
    public StageResult<T> executeWithReturn(StageResource stageResource) {
        System.out.println("executeWithReturn Resource [" + stageResource.sourceName() + "]");
        return null;
    }
}
