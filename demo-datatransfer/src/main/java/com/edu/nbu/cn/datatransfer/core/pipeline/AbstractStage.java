package com.edu.nbu.cn.datatransfer.core.pipeline;

import com.edu.nbu.cn.datatransfer.core.executor.Executor;
import com.edu.nbu.cn.datatransfer.core.source.StageResource;
import com.edu.nbu.cn.datatransfer.core.source.StageResult;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/25-4:17 下午
 * @since 1.0
 */
public abstract class AbstractStage<T> implements Stage{
    protected String name;
    protected Integer order;
    protected boolean usePreviousResult;
    protected StageResource stageResource;
    protected Executor executor;

    protected StageResult<T> result;


    public AbstractStage(String name,Integer order) {
        this.name = name;
        this.order = order;
    }


    @Override
    public String name() {
        return name;
    }

    @Override
    public StageResource resource() {
        return null;
    }

    @Override
    public StageResult<T> stageResult() {
        return result;
    }

    @Override
    public int getOrder() {
        return order;
    }

    @Override
    public boolean usePreviousResult(){
        return usePreviousResult;
    }



    @Override
    public int compareTo(Stage o) {
        return this.order - o.getOrder();
    }
}
