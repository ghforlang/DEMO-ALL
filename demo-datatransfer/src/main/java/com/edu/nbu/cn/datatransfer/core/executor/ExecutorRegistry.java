package com.edu.nbu.cn.datatransfer.core.executor;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author laoshi . hua
 * @version 1.0 2022/4/2-5:45 PM
 * @since 1.0
 */
public class ExecutorRegistry {

    private static final Map<String,Executor> executorRegistry = new HashMap<>();

    public static boolean registerExecutor(Executor executor){
        executorRegistry.putIfAbsent(executor.name(),executor);
        return true;
    }


    public static Set<Executor> selectAllExecutors(){
        return  (Set<Executor>) executorRegistry.values();
    }

    public static Executor getExecutor(String executorName){
        return executorRegistry.get(executorName);
    }

    public static Executor getCodeGeneratorExecutor(){
        return getExecutor("");
    }
}
