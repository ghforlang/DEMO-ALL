package com.edu.nbu.cn.boot.ext.aware;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author laoshi . hua
 * @version 1.0 2023/2/1-11:03 AM
 * @since 1.0
 */
@Component
public class DemoService2<T> implements ApplicationListener<ContextRefreshedEvent> {
    private ApplicationContext applicationContext;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        this.applicationContext = event.getApplicationContext();
    }

    public T getBean(String beanName){
        return (T)applicationContext.getBean(beanName);
    }
}
