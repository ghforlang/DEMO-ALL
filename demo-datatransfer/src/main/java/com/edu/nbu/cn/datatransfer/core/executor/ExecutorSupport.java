package com.edu.nbu.cn.datatransfer.core.executor;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/31-10:08 AM
 * @since 1.0
 */
@Component
public class ExecutorSupport implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    private static final Map<String,Executor> executorRegistry = new HashMap<>();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public boolean registerExecutor(Executor executor){
        executorRegistry.putIfAbsent(executor.name(),executor);
        return true;
    }


    public Set<Executor> selectAllExecutors(){
       return  (Set<Executor>) executorRegistry.values();
    }

    public Executor getExecutor(String executorName){
        return executorRegistry.get(executorName);
    }

    public Executor getCodeGeneratorExecutor(){
        return getExecutor("");
    }
}
