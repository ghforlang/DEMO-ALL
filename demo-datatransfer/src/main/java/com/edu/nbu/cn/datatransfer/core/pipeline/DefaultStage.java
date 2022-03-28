package com.edu.nbu.cn.datatransfer.core.pipeline;


import com.edu.nbu.cn.datatransfer.core.source.DefaultStageResource;
import com.edu.nbu.cn.datatransfer.core.source.Executor;
import com.edu.nbu.cn.datatransfer.core.source.StageResource;

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

    public static class Builder{
        private String name;
        private Integer order;
        private String sourceName;
        private Executor executor;

        public Builder(String name){
            this.name = name;
        }

        public static DefaultStage.Builder builder(String name){
            return new Builder(name);
        }

        public  DefaultStage.Builder sourceName(String sourceName){
            this.sourceName = sourceName;
            return this;
        }

        public DefaultStage.Builder order(Integer order){
            this.order = order;
            return this;
        }

        public DefaultStage.Builder executor(Executor executor){
            this.executor =  executor;
            return this;
        }

        public DefaultStage build(){
            return new DefaultStage(name, order, new DefaultStageResource(sourceName),executor);
        }
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
