package com.edu.nbu.cn.boot.ext.all;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author laoshi . hua
 * @version 1.0 2023/8/23-4:58 PM
 * @since 1.0
 * 扩展方式：
 * 1、通过springApplication.addInitializers(new DemoApplicationContextInitializer())，扩展引入
 * 2、通过application.properties配置文件加载 context.initializer.classes=com.edu.nbu.cn.boot.ext.all.DemoApplicationContextInitializer
 * 3、Spring SPI扩展；org.springframework.context.ApplicationContextInitializer=com.edu.nbu.cn.boot.ext.all.DemoApplicationContextInitializer
 */
@Slf4j
public class DemoApplicationContextInitializer implements ApplicationContextInitializer {
    private static final Integer order = 1;
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println(this.getClass().getName() + "#initialize()" + " is executing  in order " + order);
    }
}
