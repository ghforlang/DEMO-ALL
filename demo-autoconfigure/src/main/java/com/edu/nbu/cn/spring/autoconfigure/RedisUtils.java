package com.edu.nbu.cn.spring.autoconfigure;

import com.alibaba.fastjson.JSON;
import org.springframework.data.redis.core.RedisTemplate;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author laoshi . hua
 * @version 1.0 2023/2/6-7:38 PM
 * @since 1.0
 */
public class RedisUtils {

    public RedisTemplate getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    private RedisTemplate redisTemplate;


    /**
     * 缓存。当expireMinutes小于等于0时，默认失效时间为24小时
     *
     * @param key           缓存的键
     * @param obj           缓存的对象
     * @param expireMinutes 缓存失效时间，单位为分钟
     */
    public void set(String key, Object obj, long expireMinutes) {
        if (obj == null) {
            return;
        }

        // 如果失效时间小于0，代表调用者不关心失效时间。此处默认为24小时为失效时间
        if (expireMinutes <= 0) {
            expireMinutes = 60 * 24;
        }
        if(!(obj instanceof String)){
            String jsonValue = JSON.toJSONString(obj);
            redisTemplate.opsForValue().set(key, jsonValue);
        }else{
            redisTemplate.opsForValue().set(key, obj);
        }
        redisTemplate.expire(key, expireMinutes, TimeUnit.MINUTES);
    }

    /**
     * 缓存。当expireMinutes小于等于0时，默认失效时间为24小时
     *
     * @param key           缓存的键
     * @param content       缓存的字符串
     * @param expireMinutes 缓存失效时间，单位为分钟
     */
    public void setString(String key, String content, long expireMinutes) {
        if (content == null) {
            return;
        }

        // 如果失效时间小于0，代表调用者不关心失效时间。此处默认为24小时为失效时间
        if (expireMinutes <= 0) {
            expireMinutes = 60 * 24;
        }

        redisTemplate.opsForValue().set(key, content);
        redisTemplate.expire(key, expireMinutes, TimeUnit.MINUTES);
    }

    /**
     * 根据key查询缓存的值，并做反序列化
     *
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T get(String key, Class<T> clazz) {
        Object value = redisTemplate.opsForValue().get(key);
        if (Objects.isNull(value)) {
            return null;
        }

        return JSON.parseObject((String)value, clazz);
    }

    /**
     * 获取原始的字符串缓存
     *
     * @param key
     * @return
     */
    public String getStringCache(String key) {
        Object obj = redisTemplate.opsForValue().get(key);
        return Objects.isNull(obj) ? "" : obj.toString() ;
    }

    /**
     * 删除Key
     *
     * @param key
     * @return
     */
    public void delete(String key) {
        redisTemplate.delete(key);
    }



    /**
     * 主动失效某个key的缓存
     *
     * @param key
     * @return
     */
    public Boolean expire(String key) {
        return redisTemplate.expire(key, 5, TimeUnit.SECONDS);
    }
}
