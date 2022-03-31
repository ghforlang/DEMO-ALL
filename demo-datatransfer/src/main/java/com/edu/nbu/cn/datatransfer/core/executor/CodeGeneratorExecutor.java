package com.edu.nbu.cn.datatransfer.core.executor;

import com.edu.nbu.cn.datatransfer.core.source.StageResource;
import com.edu.nbu.cn.datatransfer.core.source.StageResult;
import com.edu.nbu.cn.datatransfer.generator.JavaCodeGenerator;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/30-6:21 PM
 * @since 1.0
 */
@Component
public class CodeGeneratorExecutor extends AbstractExecutor implements InitializingBean {

    @Autowired
    private JavaCodeGenerator javaCodeGenerator;
    @Autowired
    private ExecutorSupport executorSupport;

    @Override
    public String name() {
        return InternalExecutorType.CODE_GENERATOR_EXECUTOR.getName();
    }

    @Override
    public void execute(StageResource stageResource, StageResult previousStageResult) {
        javaCodeGenerator.generator(stageResource.sourceName());
        logger.info("execute Resource [" + stageResource.sourceName() + "]" + ",using executor[" + name() + "]");
    }

    @Override
    public StageResult executeWithReturn(StageResource stageResource, StageResult previousStageResult) {
        throw  new UnsupportedOperationException("not supportOperation!");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("register to executorRegistry,executor[" + this.name() + "]");
        executorSupport.registerExecutor(this);
    }
}
