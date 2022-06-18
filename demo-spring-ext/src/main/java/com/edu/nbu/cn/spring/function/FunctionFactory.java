package com.edu.nbu.cn.spring.function;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author laoshi . hua
 * @version 1.0 2022/6/18-11:42 AM
 * @since 1.0
 */
public class FunctionFactory<S,T> {

    public  FunctionRegistry registry = FunctionRegistry.newInstance();

    public void register(Object identifier, Function<S,T> function){
        registry.registerFunction(identifier,function);
    }

    public Function<S,T> get(Object identifier){
        return registry.fetchFunction(identifier);
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
