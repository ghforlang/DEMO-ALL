package com.edu.nbu.cn.boot.ext.modifybd;

import com.edu.nbu.cn.boot.ext.modifybd.model.CustomBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author laoshi . hua
 * @version 1.0 2023/2/9-11:23 AM
 * @since 1.0
 */
@Component
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) beanFactory;
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(CustomBean.class);
        beanDefinitionBuilder.addPropertyValue("beanName","张三");
        beanDefinitionBuilder.addPropertyValue("beanContent","张三的歌");
        defaultListableBeanFactory.registerBeanDefinition("customBean",beanDefinitionBuilder.getBeanDefinition());
    }
}
