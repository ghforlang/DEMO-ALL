package com.edu.nbu.cn.spring.factory;

/**
 * @author laoshi . hua
 * @version 1.0 2022/6/23-3:33 PM
 * @since 1.0
 */
public interface Holder<T> {
    T get();

    void set(T t);
}
