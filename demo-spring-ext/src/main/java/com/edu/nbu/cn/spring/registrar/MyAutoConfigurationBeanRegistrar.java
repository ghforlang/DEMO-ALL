package com.edu.nbu.cn.spring.registrar;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;

/**
 *
 * @version 1.0
 * @Date 2021/2/3 11:42 上午
 * @since 1.0
 */
public class MyAutoConfigurationBeanRegistrar implements ImportBeanDefinitionRegistrar, ResourceLoaderAware, BeanFactoryAware {

    private ResourceLoader resourceLoader;
    private BeanFactory beanFactory;

    private static final String SCAN_PACKAGE = "com.edu.nbu.cn.demo.registrar.model";

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        MyClassPathBeanDefinitionScanner myClassPathBeanDefinitionScanner = new MyClassPathBeanDefinitionScanner(beanDefinitionRegistry,false);
        myClassPathBeanDefinitionScanner.setResourceLoader(resourceLoader);
        myClassPathBeanDefinitionScanner.registerDefaultFilters();
        myClassPathBeanDefinitionScanner.doScan(SCAN_PACKAGE);

    }
}
