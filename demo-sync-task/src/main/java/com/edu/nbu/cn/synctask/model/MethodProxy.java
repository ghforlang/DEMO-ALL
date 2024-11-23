package com.edu.nbu.cn.synctask.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.lang.reflect.Method;

/**
 * @author laoshi . hua
 * @version 1.0 2023/11/27-4:53 PM
 * @since 1.0
 */

@Getter
@Setter
public class MethodProxy<T> implements Serializable {
    /**
     * 实例
     */
    private Object beanObject;

    /**
     * 方法
     */
    private Method method;

    /**
     * 实例类型
     */
    private Class<T> clazz;
}
