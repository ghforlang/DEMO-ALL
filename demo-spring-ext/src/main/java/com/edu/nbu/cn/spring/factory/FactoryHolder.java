package com.edu.nbu.cn.spring.factory;

import java.util.Objects;

/**
 * @author laoshi . hua
 * @version 1.0 2022/6/18-2:47 PM
 * @since 1.0
 */
public class FactoryHolder implements Holder<FunctionFactory>{
    private static FunctionFactory factoryCache = null;

    static{
        factoryCache = new FunctionFactory();
    }

    private FactoryHolder(){}

    public static FactoryHolder getInstance(){
        return new FactoryHolder();
    }

    @Override
    public FunctionFactory get() {
        return factoryCache;
    }

    @Override
    public void set(FunctionFactory functionFactory) {
        factoryCache = new FunctionFactory();
    }
}
