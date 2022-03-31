package com.edu.nbu.cn.datatransfer.core;

import com.edu.nbu.cn.datatransfer.core.executor.CodeGeneratorExecutor;
import com.edu.nbu.cn.datatransfer.core.pipeline.DefaultPipeline;
import com.edu.nbu.cn.datatransfer.core.pipeline.DefaultStage;
import com.edu.nbu.cn.datatransfer.core.pipeline.Stage;
import com.edu.nbu.cn.datatransfer.core.executor.DefaultExecutor;
import com.edu.nbu.cn.datatransfer.core.source.DefaultStageResult;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/25-3:17 下午
 * @since 1.0
 */
public class Test {



    public static void main(String[] args) {
//        testPipeline();
//        testListIterator();
//        testPreviousMap();
    }

    private static void testPipeline(){
        DefaultPipeline pipeline = new DefaultPipeline();

        DefaultStage stage = new DefaultStage.Builder("codeGenerator")
                .sourceName("codeGenerator")
                .executor(new CodeGeneratorExecutor())
                .order(1)
                .stageResult(DefaultStageResult.of("success"))
                .usePreviousResult(false)
                .build();

        DefaultStage stage1 = new DefaultStage.Builder("test")
                .sourceName("test.sql")
                .executor(new DefaultExecutor())
                .order(112)
                .stageResult(DefaultStageResult.of("Success"))
                .usePreviousResult(false)
                .build();

        DefaultStage stage2 = new DefaultStage.Builder("ttt")
                .sourceName("ttt.sql")
                .executor(new DefaultExecutor())
                .order(10)
                .stageResult(DefaultStageResult.of("Success"))
                .usePreviousResult(false)
                .build();
        // 装配stages
        pipeline.plugin(new Stage[]{stage,stage1,stage2});
        // 执行stages
        pipeline.execute();
    }

    private static void testListIterator(){
        List<String> strList = Arrays.asList("1","2","b");
        ListIterator<String> strListIterator = strList.listIterator();
        while (strListIterator.hasNext()){
            String tempStr = strListIterator.next();
            System.out.println(tempStr);
            if(strListIterator.hasPrevious()){
                strListIterator.next();
                System.out.println("previous value : " + strListIterator.previous());
            }

        }
    }

    private static void testSQLScriptExecutor(){

    }
}
