package com.edu.nbu.cn.datatransfer.core.source;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/28-11:30 上午
 * @since 1.0
 */
public class DefaultStageResource extends AbstractStageResource{

    public DefaultStageResource(String sourceName) {
        super(sourceName);
    }

    @Override
    public String sourceName() {
        return super.sourceName();
    }

    @Override
    public boolean hasResult() {
        return super.hasResult();
    }
}
