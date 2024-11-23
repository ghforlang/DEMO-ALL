package com.edu.nbu.cn.boot.ext.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author laoshi . hua
 * @version 1.0 2023/2/1-10:41 AM
 * @since 1.0
 */
@Configuration
public class CheckConfiguration extends WebMvcConfigurerAdapter {

    @Bean
    public CheckInterceptor checkInterCeptor(){
        return new CheckInterceptor();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(checkInterCeptor());
    }
}
