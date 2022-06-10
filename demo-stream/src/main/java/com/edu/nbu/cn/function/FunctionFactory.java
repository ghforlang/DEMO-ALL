package com.edu.nbu.cn.function;

import com.edu.nbu.cn.function.base.Param;
import com.edu.nbu.cn.function.base.Response;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/**
 * @author laoshi . hua
 * @version 1.0 2022/6/10-11:25 AM
 * @since 1.0
 */
public class FunctionFactory {

    private static Map<String, Function<Param, Response>> demoFunctionRegistry = new ConcurrentHashMap<>();
    private static Map<String,Function<String,String>> simpleFunctionRegistry = new ConcurrentHashMap<>();


    public static void register(String resourceId,Function<Param,Response> function){
        demoFunctionRegistry.putIfAbsent(resourceId,function);
    }

    public static Function<Param,Response> getByResourceId(String resourceId){
        return demoFunctionRegistry.get(resourceId);
    }

    public static void simpleRegister(String type,Function<String,String> function){
        simpleFunctionRegistry.putIfAbsent(type,function);
    }

    public static Function<String,String> simpleGet(String type){
        return simpleFunctionRegistry.get(type);
    }
}
