package com.edu.nbu.cn.datatransfer.core.executor;

import com.edu.nbu.cn.datatransfer.core.source.DefaultStageResult;
import com.edu.nbu.cn.datatransfer.core.source.StageResource;
import com.edu.nbu.cn.datatransfer.core.source.StageResult;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/31-4:23 PM
 * @since 1.0
 */
@Component
public class JarFileExecutor extends AbstractExecutor<String> implements InitializingBean {

    @Autowired
    private ExecutorSupport executorSupport;

    @Override
    public void execute(StageResource stageResource, StageResult stageResult) {
        super.execute(stageResource,null);
    }

    @Override
    public StageResult<String> executeWithReturn(StageResource stageResource, StageResult stageResult) {
        super.executeWithReturn(stageResource, stageResult);
        return DefaultStageResult.of("successful!");
    }

    @Override
    public String name() {
        return InternalExecutorType.JAR_FILE_EXECUTOR.getName();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("register to executorRegistry,executor[" + this.name() + "]");
        executorSupport.registerExecutor(this);
    }
}
