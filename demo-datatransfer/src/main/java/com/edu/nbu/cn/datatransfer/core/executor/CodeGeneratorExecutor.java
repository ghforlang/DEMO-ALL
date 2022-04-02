package com.edu.nbu.cn.datatransfer.core.executor;

import com.edu.nbu.cn.datatransfer.core.source.StageResource;
import com.edu.nbu.cn.datatransfer.core.source.StageResult;
import lombok.extern.slf4j.Slf4j;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/30-6:21 PM
 * @since 1.0
 */
@Slf4j
public class CodeGeneratorExecutor extends JarFileExecutor{

    public CodeGeneratorExecutor() {
        log.info("register to executorRegistry,executor[" + this.name() + "]");
        ExecutorRegistry.registerExecutor(this);
    }


    @Override
    public String name() {
        return InternalExecutorType.CODE_GENERATOR_EXECUTOR.getName();
    }

    @Override
    public void execute(StageResource stageResource, StageResult previousStageResult) {
        super.execute(stageResource,previousStageResult);
        log.info("execute Resource [" + stageResource.sourceName() + "]" + ",using executor[" + name() + "]");
    }

    @Override
    public StageResult executeWithReturn(StageResource stageResource, StageResult previousStageResult) {
        throw  new UnsupportedOperationException("not supportOperation!");
    }

}
