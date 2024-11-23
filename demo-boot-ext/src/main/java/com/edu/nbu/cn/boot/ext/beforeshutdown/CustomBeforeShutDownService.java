package com.edu.nbu.cn.boot.ext.beforeshutdown;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author laoshi . hua
 * @version 1.0 2023/2/9-2:42 PM
 * @since 1.0
 */
@Component
@Slf4j
public class CustomBeforeShutDownService implements InitializingBean, DisposableBean {

    public void shutDown(){
        log.info("CustomBeforeShutDownService is being shutdown!");
    }

    @Override
    public void destroy() throws Exception {
        log.info("bean CustomBeforeShutDownService is destroying !");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("bean CustomBeforeShutDownService is initializing!");
    }
}
