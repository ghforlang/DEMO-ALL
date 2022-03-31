package com.edu.nbu.cn.datatransfer.core.pipeline;

import com.edu.nbu.cn.datatransfer.core.source.DefaultStageResult;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/31-3:11 PM
 * @since 1.0
 */
public enum InternalStageType {
    PREPARED(InternalStage.PREPARED.getName(), StageHolder.preparedStage),
    DEFAULT(InternalStage.DEFAULT.getName(), StageHolder.commonStage),
    CODE_GENERATOR(InternalStage.CODE_GENERATOR.getName(), StageHolder.codeGenerateStage),
    SQL_SCRIPT(InternalStage.SQL_SCRIPT.getName(), StageHolder.sqlExecuteStage)
    ;

    public String getName() {
        return name;
    }

    InternalStageType(String name,DefaultStage stage) {
        this.name = name;
        this.stage = stage;
    }

    private String name;
    private DefaultStage stage;

    public DefaultStage getStage() {
        return stage;
    }


    static class StageHolder{
       private static  DefaultStage preparedStage = new DefaultStage.Builder(InternalStage.PREPARED.getName())
                .order(1)
                .stageResult(DefaultStageResult.of("success"))
                .usePreviousResult(false)
                .build();

       public static  DefaultStage commonStage = new DefaultStage.Builder(InternalStage.DEFAULT.getName())
               .stageResult(DefaultStageResult.of("success"))
               .usePreviousResult(false)
               .build();

       public static DefaultStage codeGenerateStage = new DefaultStage.Builder(InternalStage.CODE_GENERATOR.getName())
               .sourceName("codeGenerator")
               .stageResult(DefaultStageResult.of("success"))
               .usePreviousResult(false)
               .build();

       public static DefaultStage sqlExecuteStage =  new DefaultStage.Builder(InternalStage.SQL_SCRIPT.getName())
               .stageResult(DefaultStageResult.of("Success"))
               .usePreviousResult(false)
               .build();
    }
}
