package com.edu.nbu.cn.boot.ext.scope;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author laoshi . hua
 * @version 1.0 2023/2/9-3:21 PM
 * @since 1.0
 */
@Component
public class ScopeApplicationUtils implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public <T>T getBean(Class beanClass){
        return (T)applicationContext.getBean(beanClass);
    }
}
