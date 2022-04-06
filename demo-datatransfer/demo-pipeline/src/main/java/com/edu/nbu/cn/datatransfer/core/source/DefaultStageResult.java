package com.edu.nbu.cn.datatransfer.core.source;



/**
 * @author laoshi . hua
 * @version 1.0 2022/3/25-4:48 下午
 * @since 1.0
 */
public class DefaultStageResult implements StageResult<String>{

    private String data;


    public DefaultStageResult(String data) {
        this.data = data;
    }


    @Override
    public String result() {
        return data;
    }

    public static DefaultStageResult of(String t){
        return new DefaultStageResult(t);
    }
}
