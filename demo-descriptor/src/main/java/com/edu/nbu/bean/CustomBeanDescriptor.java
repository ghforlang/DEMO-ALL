package com.edu.nbu.bean;

import java.beans.BeanDescriptor;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/16-4:58 下午
 * @since 1.0
 */
public class CustomBeanDescriptor extends BeanDescriptor {
    public CustomBeanDescriptor(Class<?> beanClass, Class<?> customizerClass) {
        super(beanClass, customizerClass);
    }
}
