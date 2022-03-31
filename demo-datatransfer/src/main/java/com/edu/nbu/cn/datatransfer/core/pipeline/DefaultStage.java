package com.edu.nbu.cn.datatransfer.core.pipeline;


import com.edu.nbu.cn.datatransfer.core.source.DefaultStageResource;
import com.edu.nbu.cn.datatransfer.core.executor.Executor;
import com.edu.nbu.cn.datatransfer.core.source.StageResource;
import com.edu.nbu.cn.datatransfer.core.source.StageResult;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/25-4:25 下午
 * @since 1.0
 */

public class DefaultStage<T> extends AbstractStage {

    public DefaultStage(String name, Integer order) {
        super(name, order);
    }

    private DefaultStage(String name, Integer order, StageResource stageResource, Executor executor,StageResult<T> result,boolean usePreviousResult) {
        this(name, order);
        this.stageResource = stageResource;
        this.executor = executor;
        this.result = result;
        this.usePreviousResult = usePreviousResult;
    }

    public static class Builder{
        private String name;
        private Integer order;
        private String sourceName;
        private Executor executor;
        private StageResult result;
        private boolean usePreviousResult;

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

        public DefaultStage.Builder stageResult(StageResult result){
            this.result = result;
            return this;
        }

        public DefaultStage.Builder usePreviousResult(boolean usePreviousResult){
            this.usePreviousResult = usePreviousResult;
            return this;
        }

        public DefaultStage build(){
            return new DefaultStage(name, order, new DefaultStageResource(sourceName),executor,result,usePreviousResult);
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

    @Override
    public void assembleResult(StageResult result) {
        this.result = result;
    }

}
