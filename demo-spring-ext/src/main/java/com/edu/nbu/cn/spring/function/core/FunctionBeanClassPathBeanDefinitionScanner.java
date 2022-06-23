package com.edu.nbu.cn.spring.function.core;

import com.edu.nbu.cn.spring.function.core.anno.FunctionBean;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.util.Set;

/**
 * @author laoshi . hua
 * @version 1.0 2022/6/23-2:54 PM
 * @since 1.0
 */
public class FunctionBeanClassPathBeanDefinitionScanner extends ClassPathBeanDefinitionScanner {

    public FunctionBeanClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry,boolean useDefaultFilters) {
        super(registry,false);
    }


    @Override
    protected void registerDefaultFilters() {
        addIncludeFilter(new AnnotationTypeFilter(FunctionBean.class));
    }

    @Override
    protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
        return super.doScan(basePackages);
    }
}
