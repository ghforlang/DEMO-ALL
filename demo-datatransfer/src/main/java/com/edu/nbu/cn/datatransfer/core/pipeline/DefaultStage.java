package com.edu.nbu.cn.datatransfer.core.pipeline;

import com.edu.nbu.cn.datatransfer.core.source.Executor;
import com.edu.nbu.cn.datatransfer.core.source.StageResource;
import lombok.Getter;
import lombok.Setter;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/25-4:25 下午
 * @since 1.0
 */

public class DefaultStage extends AbstractStage {
    private StageResource stageResource;
    private Executor executor;

    public DefaultStage(String name, Integer order) {
        super(name, order);
    }

    public DefaultStage(String name, Integer order, StageResource stageResource, Executor executor) {
        super(name, order);
        this.stageResource = stageResource;
        this.executor = executor;
    }


    @Override
    public StageResource resource() {
        return stageResource;
    }

    @Override
    public Executor getExecutor() {
        return executor;
    }
}
