package com.edu.nbu.cn.boot.ext.all;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

/**
 * @author laoshi . hua
 * @version 1.0 2023/8/24-10:22 AM
 * @since 1.0
 */
@Component
@Slf4j
public class DemoBeanNameAware implements BeanNameAware {
    @Override
    public void setBeanName(String name) {
        log.info(this.getClass().getName() + "#setBeanName()" + " is executing  in order " + 12);
    }
}
