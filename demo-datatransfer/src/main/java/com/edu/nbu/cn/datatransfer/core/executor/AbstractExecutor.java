package com.edu.nbu.cn.datatransfer.core.executor;


import com.edu.nbu.cn.datatransfer.core.source.StageResource;
import com.edu.nbu.cn.datatransfer.core.source.StageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author laoshi . hua
 * @version 1.0 2022/3/25-3:47 下午
 * @since 1.0
 */
public abstract class AbstractExecutor<T> implements Executor {

    Logger logger = LoggerFactory.getLogger(AbstractExecutor.class);

    @Override
    public void execute(StageResource stageResource, StageResult previousStageResult) {
        if(stageResource.hasResult()){
            System.out.println("Resource need return result,please use executeWithReturn[" + stageResource.sourceName() + "]");
        }
        logger.info("execute Resource [" + stageResource.sourceName() + "]" + ",using executor[" + name() + "]");
    }

    @Override
    public StageResult<T> executeWithReturn(StageResource stageResource,StageResult previousStageResult) {
        logger.info("executeWithReturn Resource [" + stageResource.sourceName() + "],using executor[" + name() +"]");
        return null;
    }
}
