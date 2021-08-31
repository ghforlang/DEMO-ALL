package com.edu.nbu.cn.spring.registrar;

import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.util.Set;

/**
 *
 * @version 1.0
 * @Date 2021/2/3 11:44 上午
 * @since 1.0
 */
public class MyClassPathBeanDefinitionScanner extends ClassPathBeanDefinitionScanner {


    public MyClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry, boolean useDefaultFilters) {
        super(registry, false);
    }

    @Override
    protected void registerDefaultFilters() {
        // 打开注释，会默认加载使用了spring注解的bean
//        super.registerDefaultFilters();
        addIncludeFilter(new AnnotationTypeFilter(MyTest.class));
        //同样的，满足任务excludeFilters的不会被加载；
        // 父类在constructor内部调用ClassPathScanningCandidateComponentProvider的构造方法
        // 默认会开启使用spring注解的bean的加载（即，默认会执行registerDefaultFilters方法），
        // 另外AnnotationConfigApplicationContext在初始化的时候也会调用ClassPathBeanDefinitionScanner的constructor（同样默认开启使用spring注解的bean的加载流程）；
        // 这里可以在构造方法中
        // 是否在子类构造方法尝试将其关闭super(registry,false)；
        //
//        addExcludeFilter(new AnnotationTypeFilter(Service.class));
//        addExcludeFilter(new AnnotationTypeFilter(Component.class));
    }

    @Override
    protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
        return super.doScan(basePackages);
    }
}
