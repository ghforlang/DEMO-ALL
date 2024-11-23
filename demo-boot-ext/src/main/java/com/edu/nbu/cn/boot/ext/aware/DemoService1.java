package com.edu.nbu.cn.boot.ext.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

/**
 * @author laoshi . hua
 * @version 1.0 2023/2/1-11:02 AM
 * @since 1.0
 */
@Component
public class DemoService1<T> implements BeanFactoryAware {

    private BeanFactory beanFactory;


    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public T getBean(String beanName){
        return (T)beanFactory.getBean(beanName);
    }
}
