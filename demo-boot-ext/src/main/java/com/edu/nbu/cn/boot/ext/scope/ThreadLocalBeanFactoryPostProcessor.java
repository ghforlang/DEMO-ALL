package com.edu.nbu.cn.boot.ext.scope;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author laoshi . hua
 * @version 1.0 2023/2/9-2:52 PM
 * @since 1.0
 */
@Component
public class ThreadLocalBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        beanFactory.registerScope("threadLocalScope",new ThreadLocalScope());
    }
}
