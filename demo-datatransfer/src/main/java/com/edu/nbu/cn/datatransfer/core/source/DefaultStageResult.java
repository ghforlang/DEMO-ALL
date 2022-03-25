package com.edu.nbu.cn.datatransfer.core.source;

import org.apache.poi.ss.formula.functions.T;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/25-4:48 下午
 * @since 1.0
 */
public class DefaultStageResult implements StageResult<T>{

    private T data;

    public DefaultStageResult(T data) {
        this.data = data;
    }


    @Override
    public T result() {
        return data;
    }

    public static DefaultStageResult of(T t){
        return new DefaultStageResult(t);
    }
}
