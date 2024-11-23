package com.edu.nbu.cn.boot.ext.all;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;

/**
 * @author laoshi . hua
 * @version 1.0 2023/8/24-10:10 AM
 * @since 1.0
 */
@Component
@Slf4j
public class DemoInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        log.info(this.getClass().getName() + "#postProcessBeforeInstantiation()" + " is executing  in order " + 5);
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        log.info(this.getClass().getName() + "#postProcessAfterInstantiation()" + " is executing  in order " + 8);
        return false;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        log.info(this.getClass().getName() + "#postProcessPropertyValues()" + " is executing  in order " + 11);
        return pvs;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info(this.getClass().getName() + "#postProcessBeforeInitialization()" + " is executing  in order " + 2);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info(this.getClass().getName() + "#postProcessAfterInitialization()" + " is executing  in order " + 15);
        return bean;
    }
}
