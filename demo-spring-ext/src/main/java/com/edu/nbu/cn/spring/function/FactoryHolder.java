package com.edu.nbu.cn.spring.function;

import java.util.Objects;

/**
 * @author laoshi . hua
 * @version 1.0 2022/6/18-2:47 PM
 * @since 1.0
 */
public class FactoryHolder {
    private static final ThreadLocal<FunctionFactory> factoryHolder = new ThreadLocal<>();

    public static FunctionFactory factory(){
        if(Objects.nonNull(factoryHolder.get())){
            return factoryHolder.get();
        }
        factoryHolder.set(new FunctionFactory());
        return factoryHolder.get();
    }
}
