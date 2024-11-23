package com.edu.nbu.cn.synctask.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.LinkedHashMap;

/**
 * @author laoshi . hua
 * @version 1.0 2023/11/27-5:40 PM
 * @since 1.0
 */
@ConfigurationProperties(prefix = "async.datasource")
public class DataSourceConfiguration extends LinkedHashMap<String,Object> {
}
