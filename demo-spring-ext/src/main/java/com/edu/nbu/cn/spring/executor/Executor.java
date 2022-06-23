package com.edu.nbu.cn.spring.executor;

/**
 * @author laoshi . hua
 * @version 1.0 2022/6/22-4:48 PM
 * @since 1.0
 */
public interface Executor<T> {

    boolean validIdentifier(T identifier);
}
