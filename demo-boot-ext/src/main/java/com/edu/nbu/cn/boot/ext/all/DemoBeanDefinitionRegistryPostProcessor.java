package com.edu.nbu.cn.boot.ext.all;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author laoshi . hua
 * @version 1.0 2023/8/23-5:23 PM
 * @since 1.0
 * processor最终还是要作为一个bean被处理,然后通过BeanFactory使用
 */
@Component
@Slf4j
public class DemoBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        log.info(this.getClass().getName() + "#postProcessBeanDefinitionRegistry()" + " is executing  in order " + 2);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        log.info(this.getClass().getName() + "#postProcessBeanFactory()" + " is executing  in order " + 3);
    }
}
