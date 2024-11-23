package com.edu.nbu.cn.boot.ext.init;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author laoshi . hua
 * @version 1.0 2023/2/9-2:39 PM
 * @since 1.0
 */
@Component
@Slf4j
public class CustomInitializeService2 implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
//        log.info("CustomInitializeService2 is initializing!");
    }

    public void test(){
        log.info("this is A CustomInitializeService2 test!");
    }
}
