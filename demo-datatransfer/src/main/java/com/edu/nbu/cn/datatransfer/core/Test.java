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
        testPipeline();
//        testListIterator();
//        testPreviousMap();
    }

    private static void testPipeline(){

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

}
