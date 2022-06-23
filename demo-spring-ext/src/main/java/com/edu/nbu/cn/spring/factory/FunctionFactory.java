package com.edu.nbu.cn.spring.factory;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

/**
 * @author laoshi . hua
 * @version 1.0 2022/6/18-11:42 AM
 * @since 1.0
 */

public class FunctionFactory<S,T> {
    private Map<String,FunctionRegistry> registryMap = new HashMap<>();

    public void register(Class<?> serviceClass,Object identifier, Function<S,T> function){
        registryMap.putIfAbsent(serviceClass.getName(), FunctionRegistry.newInstance());
        registryMap.get(serviceClass.getName()).registerFunction(identifier,function);
    }

    public Function<S,T> get(Class<?> serviceClass,Object identifier){
        if(Objects.isNull(registryMap.get(serviceClass.getName()))){
//            LOGGER.warn("interface{} has no registry available");
            return null;
        }
        if(Objects.isNull(registryMap.get(serviceClass.getName()).fetchFunction(identifier))){
            throw new RuntimeException("invalid functionRegistry!");
        }
        return registryMap.get(serviceClass.getName()).fetchFunction(identifier);
    }

    static class FunctionRegistry<S,T>{
        private Map<Object,Function<S,T>> functionCache = new HashMap<>();
        private  FunctionRegistry() {
        }

        static FunctionRegistry  newInstance(){
            return new FunctionRegistry<>();
        }

        private  void registerFunction(Object identifier,Function<S,T> function){
            functionCache.putIfAbsent(identifier,function);
        }

        private Function<S,T> fetchFunction(Object identifier){
            return functionCache.get(identifier);
        }
    }
}
