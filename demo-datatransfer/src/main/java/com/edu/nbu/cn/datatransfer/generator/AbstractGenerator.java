package com.edu.nbu.cn.datatransfer.generator;

import org.apache.poi.ss.formula.functions.T;

/**
* @author laoshi . hua
* @since 1.0
* @version 1.0 2022/3/18-2:33 下午
*/public class AbstractGenerator<S,T> implements Generator<S, T>{
    @Override
    public  T generator(S s) {
        return null;
    }
}
