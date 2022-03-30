package com.edu.nbu.cn.datatransfer.core.executor;

import com.edu.nbu.cn.datatransfer.core.source.StageResource;
import com.edu.nbu.cn.datatransfer.core.source.StageResult;
import org.apache.poi.ss.formula.functions.T;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/25-4:08 下午
 * @since 1.0
 */
public class SQLScriptExecutor extends AbstractExecutor {
    private static final String name = "SQLScriptExecutor";

    @Override
    public void execute(StageResource stageResource, StageResult stageResult) {
        super.execute(stageResource,null);
    }

    @Override
    public StageResult<T> executeWithReturn(StageResource stageResource,StageResult stageResult) {
        return super.executeWithReturn(stageResource,null);
    }

    @Override
    public String name() {
        return name;
    }
}
