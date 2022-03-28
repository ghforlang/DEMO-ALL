package com.edu.nbu.cn.datatransfer.core.source;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/25-3:22 下午
 * @since 1.0
 */
public interface Executor<T> extends NameAwared{

    void execute(StageResource stageResource);

    StageResult<T> executeWithReturn(StageResource stageResource);
}
