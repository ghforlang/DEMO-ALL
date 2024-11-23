package com.edu.nbu.cn.synctask.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author laoshi . hua
 * @version 1.0 2023/11/27-5:41 PM
 * @since 1.0
 */
@Configuration
@ConfigurationProperties(prefix = "async",value = "true")
@EnableConfigurationProperties(DataSourceConfiguration.class)
@ComponentScan("com.edu.nbu.cn.synctask")
public class GlobalConfiguration {
}
