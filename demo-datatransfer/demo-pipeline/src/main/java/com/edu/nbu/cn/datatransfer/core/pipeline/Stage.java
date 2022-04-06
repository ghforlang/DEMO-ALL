package com.edu.nbu.cn.datatransfer.core.pipeline;

import com.edu.nbu.cn.datatransfer.core.executor.Executor;
import com.edu.nbu.cn.datatransfer.core.source.StageResource;
import com.edu.nbu.cn.datatransfer.core.source.StageResult;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/25-3:21 下午
 * @since 1.0
 */
public interface Stage extends Comparable<Stage> {

    String name();

    StageResource resource();

    Executor getExecutor();

    StageResult stageResult();

    boolean usePreviousResult();

    void assembleResult(StageResult result);

    int getOrder();
}
