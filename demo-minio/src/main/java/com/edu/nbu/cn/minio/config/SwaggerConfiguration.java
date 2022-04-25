package com.edu.nbu.cn.minio.config;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.plugin.EnableSwagger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @author laoshi . hua
 * @version 1.0 2022/4/25-4:07 PM
 * @since 1.0
 */
@Configuration
@EnableSwagger
public class SwaggerConfiguration {

    private SpringSwaggerConfig springSwaggerConfig;

    @Autowired
    public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig){
        this.springSwaggerConfig = springSwaggerConfig;
    }

    // tobe continue
}
