package com.edu.nbu.cn.spring.factory;

import com.edu.nbu.cn.spring.function.SelectableFunction;
import com.edu.nbu.cn.spring.function.core.identifier.IdentifierHelper;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

/**
 * @author laoshi . hua
 * @version 1.0 2022/6/18-11:42 AM
 * @since 1.0
 */

public class FunctionFactory<R> {
    private Map<String,FunctionRegistry> registryMap = new HashMap<>();

    public void register(Class<?> serviceClass,String identifier, Function<String,R> function){
        registryMap.putIfAbsent(serviceClass.getName(), FunctionRegistry.newInstance());
        registryMap.get(serviceClass.getName()).registerFunction(IdentifierHelper.globalIdentifier(serviceClass,identifier),function);
    }

    public SelectableFunction<R> get(Class<?> executorClass){
        if(Objects.isNull(registryMap.get(executorClass.getName()))){
//            LOGGER.warn("interface{} has no registry available");
            return null;
        }
        return new SelectableFunction<R>(executorClass,registryMap.get(executorClass.getName()).getFunctionCache());
    }

    static class FunctionRegistry<R>{

        public Map<String, Function<String, R>> getFunctionCache() {
            return functionCache;
        }

        private Map<String, Function<String,R>> functionCache = new HashMap<>();
        private  FunctionRegistry() {
        }

        static FunctionRegistry  newInstance(){
            return new FunctionRegistry<>();
        }

        private  void registerFunction(String identifier,Function<String,R> function){
            functionCache.putIfAbsent(identifier,function);
        }

        private Function<String,R> fetchFunction(String identifier){
            return functionCache.get(identifier);
        }
    }
}
