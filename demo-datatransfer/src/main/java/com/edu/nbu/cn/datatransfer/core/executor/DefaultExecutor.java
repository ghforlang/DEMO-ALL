package com.edu.nbu.cn.datatransfer.core.executor;


import com.edu.nbu.cn.datatransfer.core.source.StageResource;
import com.edu.nbu.cn.datatransfer.core.source.StageResult;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/28-1:41 下午
 * @since 1.0
 */
@Component
public class DefaultExecutor extends AbstractExecutor<String> implements InitializingBean {

    @Autowired
    private ExecutorSupport executorSupport;

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

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("register to executorRegistry,executor[" + this.name() + "]");
        executorSupport.registerExecutor(this);
    }
}