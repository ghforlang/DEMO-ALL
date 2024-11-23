package com.edu.nbu.cn.boot.ext.all;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author laoshi . hua
 * @version 1.0 2023/8/24-10:25 AM
 * @since 1.0
 */
@Component
@Slf4j
public class DemoFactoryBean implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        log.info(this.getClass().getName() + "#getObject()" + " is executing  in order " + 16);
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
