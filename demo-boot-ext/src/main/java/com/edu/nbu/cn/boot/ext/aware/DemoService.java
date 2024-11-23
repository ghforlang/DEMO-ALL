package com.edu.nbu.cn.boot.ext.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author laoshi . hua
 * @version 1.0 2023/2/1-10:59 AM
 * @since 1.0
 */
@Component
public class DemoService<T> implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public T getBean(String beanName){
        return (T)applicationContext.getBean(beanName);
    }
}
