package com.edu.nbu.cn.boot.ext.all;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author laoshi . hua
 * @version 1.0 2023/8/24-10:23 AM
 * @since 1.0
 */
@Component
@Slf4j
public class DemoBean implements DisposableBean {
    private String name;
    @PostConstruct
    public void init(){
        log.info(this.getClass().getName() + "#@PostConstruct" + " is executing  in order " + 13);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void destroy() throws Exception {
        log.info(this.getClass().getName() + "#destroy()" + " is executing  in order " + 19);
    }
}
