package com.edu.nbu.cn.bizcache.core.entity;

import com.edu.nbu.cn.bizcache.core.registry.CacheKeyRegistry;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

@Component
public class CacheKeyAssistant {

    @Resource
    private CacheKeyRegistry registry;

    /**
     * cachekey获取
     * @param obj
     * @return
     */
    public  CacheKey getCacheKey(Object obj){
        CacheKey registeredCacheKey = registry.getCacheKey(obj);
        if(Objects.isNull(registeredCacheKey)){
            //参考register-Cache相关注解实现
            CacheKey cacheKey = new CacheKey();
            registry.registerCacheKey(cacheKey);
            return cacheKey;
        }
        return registeredCacheKey;
    }



}
