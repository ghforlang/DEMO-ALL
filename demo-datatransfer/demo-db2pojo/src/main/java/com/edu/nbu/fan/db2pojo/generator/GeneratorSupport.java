package com.edu.nbu.fan.db2pojo.generator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author laoshi . hua
 * @version 1.0 2022/4/2-4:47 PM
 * @since 1.0
 */
@Component
@Slf4j
public class GeneratorSupport implements InitializingBean {

    @Autowired
    private JavaCodeGenerator javaCodeGenerator;

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("begin to generate pojo !");
        javaCodeGenerator.generator("sucess!");
        log.info("generate pojo success!");
    }
}
