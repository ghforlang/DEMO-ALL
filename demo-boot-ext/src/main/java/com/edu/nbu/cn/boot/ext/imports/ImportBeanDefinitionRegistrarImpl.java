package com.edu.nbu.cn.boot.ext.imports;

import com.edu.nbu.cn.boot.ext.imports.model.ImportBeanDefinitionRegistrarBean;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author laoshi . hua
 * @version 1.0 2023/2/9-10:15 AM
 * @since 1.0
 */
public class ImportBeanDefinitionRegistrarImpl implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        RootBeanDefinition rbd = new RootBeanDefinition(ImportBeanDefinitionRegistrarBean.class);
        registry.registerBeanDefinition("xxx",rbd);
    }
}
