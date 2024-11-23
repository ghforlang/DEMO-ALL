package com.edu.nbu.cn.boot.ext.all;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

/**
 * @author laoshi . hua
 * @version 1.0 2023/8/24-10:54 AM
 * @since 1.0
 */
@Component
@Slf4j
public class DemoDisposableBean implements DisposableBean {
    @Override
    public void destroy() throws Exception {
        log.info(this.getClass().getName() + "#destroy()" + " is executing  in order " + 19);
    }
}
