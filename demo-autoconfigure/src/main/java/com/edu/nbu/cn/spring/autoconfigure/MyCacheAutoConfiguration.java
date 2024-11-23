package com.edu.nbu.cn.spring.autoconfigure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * @author laoshi . hua
 * @version 1.0 2023/2/6-8:06 PM
 * @since 1.0
 */
@EnableConfigurationProperties(MyCacheProperties.class)
@Configuration
@ConditionalOnBean(MyCacheConfiguration.class)
public class MyCacheAutoConfiguration {

    @Resource
    private RedisTemplate myRedisTemplate;

    @Bean
    public RedisUtils myRedisUtil(){
        RedisUtils redisUtil = new RedisUtils();
        redisUtil.setRedisTemplate(myRedisTemplate);
        return redisUtil;
    }
}
