package com.edu.nbu.cn.disruptor.offical.tune;

/**
 * @author laoshi . hua
 * @version 1.0 2021/11/8-3:15 下午
 * @since 1.0
 */
public class ObjectEvent<T> {
    private T data;

    void set(T data){
        this.data = data;
    }

    void clear(){
        data = null;
    }

    T get(){
        return data;
    }
}
