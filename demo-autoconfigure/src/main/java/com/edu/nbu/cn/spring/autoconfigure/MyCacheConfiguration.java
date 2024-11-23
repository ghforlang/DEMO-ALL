package com.edu.nbu.cn.spring.autoconfigure;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

import javax.annotation.Resource;

/**
 * @author laoshi . hua
 * @version 1.0 2023/2/6-6:01 PM
 * @since 1.0
 */

@Configuration
public class MyCacheConfiguration {

    @Resource
    private MyCacheProperties myCacheProperties;

    @Bean
    public RedisConnectionFactory connectionFactory(){
        RedisSentinelConfiguration redisSentinelConfiguration = new RedisSentinelConfiguration(myCacheProperties.getMaster(), myCacheProperties.getNodes());

        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(myCacheProperties.getMaxIdle());
        jedisPoolConfig.setMinIdle(myCacheProperties.getMinIdle());
        jedisPoolConfig.setMaxTotal(myCacheProperties.getMaxActive());
        jedisPoolConfig.setMaxWaitMillis(myCacheProperties.getMaxWait());

        JedisConnectionFactory connectionFactory = new JedisConnectionFactory(redisSentinelConfiguration);
        connectionFactory.setPassword(myCacheProperties.getPassword());
        return connectionFactory;
    }

    @Bean("myRedisTemplate")
    @ConditionalOnBean(RedisConnectionFactory.class)
    public RedisTemplate<String, Object> redisTemplate(){
        //创建Json序列化对象
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);

        //解决查询缓存转换异常的问题
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);

        RedisTemplate<String, Object> template = new RedisTemplate();
        template.setKeySerializer(jackson2JsonRedisSerializer);
        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.setHashKeySerializer(jackson2JsonRedisSerializer);
        template.setHashValueSerializer(jackson2JsonRedisSerializer);
        template.setConnectionFactory(connectionFactory());
        template.afterPropertiesSet();
        return template;
    }
}
