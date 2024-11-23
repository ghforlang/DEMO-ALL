package com.edu.nbu.cn.boot.ext.bpp;

import com.edu.nbu.cn.boot.ext.modifybd.model.CustomBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author laoshi . hua
 * @version 1.0 2023/2/9-2:27 PM
 * @since 1.0
 * 我们经常使用的注解，@Autowired、@Value、@Resource、@PostConstruct
 * 是通过AutowiredAnnotationBeanPostProcessor、CommonAnnotationBeanPostProcessor实现的
 */
//@Component
@Slf4j
public class CustomBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("CustomBeanPostProcessor process before CustomBean initialize");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("CustomBeanPostProcessor process after CustomBean initialize");
        if(bean instanceof CustomBean){
           ((CustomBean) bean).setBeanName("李大大");
            log.info("customBean.beanName : {}",((CustomBean) bean).getBeanName());
        }
        return bean;
    }
}
