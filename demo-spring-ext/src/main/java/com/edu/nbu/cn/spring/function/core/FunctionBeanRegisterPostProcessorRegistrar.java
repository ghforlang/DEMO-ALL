package com.edu.nbu.cn.spring.function.core;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author laoshi . hua
 * @version 1.0 2022/6/18-7:40 PM
 * @since 1.0
 */
public class FunctionBeanRegisterPostProcessorRegistrar implements ImportBeanDefinitionRegistrar {

    private static final String FUNCTION_BEAN_NAME = "functionBeanRegisterPostProcessor";
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        if (!registry.containsBeanDefinition(FUNCTION_BEAN_NAME)) {
            BeanDefinitionBuilder bean = BeanDefinitionBuilder.genericBeanDefinition(
                    FunctionBeanRegisterPostProcessor.class);
            registry.registerBeanDefinition(FUNCTION_BEAN_NAME, bean.getBeanDefinition());
        }
    }
}
