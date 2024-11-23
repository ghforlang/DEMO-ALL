package com.edu.nbu.cn.boot.ext.all;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author laoshi . hua
 * @version 1.0 2023/8/24-10:24 AM
 * @since 1.0
 */
@Component
@Slf4j
public class DemoInitializingBean implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        log.info(this.getClass().getName() + "#afterPropertiesSet" + " is executing  in order " + 14);
    }
}
