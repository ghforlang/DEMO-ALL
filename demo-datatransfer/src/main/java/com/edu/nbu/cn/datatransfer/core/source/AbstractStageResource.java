package com.edu.nbu.cn.datatransfer.core.source;/**
* @author laoshi . hua
* @since 1.0 
* @version 1.0 2022/3/25-3:25 下午
*/public abstract class AbstractStageResource implements StageResource {

    protected String sourceName;

    public AbstractStageResource(String sourceName) {
        this.sourceName = sourceName;
    }


    @Override
    public String sourceName() {
        return sourceName;
    }

    @Override
    public boolean hasResult() {
        return false;
    }
}
