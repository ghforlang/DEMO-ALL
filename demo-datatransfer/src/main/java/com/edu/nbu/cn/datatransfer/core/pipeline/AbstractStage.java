package com.edu.nbu.cn.datatransfer.core.pipeline;

import com.edu.nbu.cn.datatransfer.core.source.Executor;
import com.edu.nbu.cn.datatransfer.core.source.StageResource;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/25-4:17 下午
 * @since 1.0
 */
public abstract class AbstractStage implements Stage{
    protected String name;
    protected Integer order;


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
    public int compareTo(Stage o) {
        return this.order - o.getOrder();
    }

    @Override
    public int getOrder() {
        return order;
    }
}
