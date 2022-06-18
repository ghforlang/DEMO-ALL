package com.edu.nbu.cn.spring.registrar;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 *
 * @version 1.0
 * @Date 2021/2/3 11:58 上午
 * @since 1.0
 */
@org.springframework.context.annotation.Configuration
//使用@Import的class是不会被加载到spring容器的
@Import(MyAutoConfigurationBeanRegistrar.class)
//指定扫描的包路径(内部bean有使用到spring的注解，这里也会进行加载)
//@ComponentScan("com.edu.nbu.cn.demo.registrar")
public class Configuration {
}
