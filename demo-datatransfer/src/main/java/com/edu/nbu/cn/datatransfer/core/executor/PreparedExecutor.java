package com.edu.nbu.cn.datatransfer.core.executor;

import com.edu.nbu.cn.datatransfer.core.source.DefaultStageResult;
import com.edu.nbu.cn.datatransfer.core.source.StageResource;
import com.edu.nbu.cn.datatransfer.core.source.StageResult;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/31-3:43 PM
 * @since 1.0
 */
@Component
public class PreparedExecutor extends  AbstractExecutor<String> implements InitializingBean {

    @Autowired
    private ExecutorSupport executorSupport;

    @Override
    public void execute(StageResource stageResource, StageResult previousStageResult) {
        super.execute(stageResource,previousStageResult);
        // do something to prepare
        logger.info("all operations has been prepared!");
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

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.debug("register to executorRegistry,executor[" + this.name() + "]");
        executorSupport.registerExecutor(this);
    }
}
