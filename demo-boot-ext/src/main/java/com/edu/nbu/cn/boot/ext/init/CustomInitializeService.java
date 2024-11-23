package com.edu.nbu.cn.boot.ext.init;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author laoshi . hua
 * @version 1.0 2023/2/9-2:38 PM
 * @since 1.0
 */
@Component
@Slf4j
public class CustomInitializeService {

    @PostConstruct
    public void init(){
        log.info("CustomInitializeService is initializing");
    }

    public void test(){
        log.info("this is A CustomInitializeService test!");
    }
}
