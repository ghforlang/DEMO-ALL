package com.edu.nbu.cn.spring.function;

import com.edu.nbu.cn.spring.factory.FactoryHolder;
import com.edu.nbu.cn.spring.factory.FunctionFactory;

/**
 * @author laoshi . hua
 * @version 1.0 2022/6/18-3:01 PM
 * @since 1.0
 */
public abstract class AbstractFunctionBeanHandler implements FunctionBeanHandler {
    protected FunctionFactory factory;



    public AbstractFunctionBeanHandler(FunctionFactory factory) {
        this.factory = FactoryHolder.getInstance().get();
    }

    public AbstractFunctionBeanHandler() {
    }
}
