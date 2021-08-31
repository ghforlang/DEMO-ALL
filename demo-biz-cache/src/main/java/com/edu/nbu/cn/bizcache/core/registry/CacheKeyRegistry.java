package com.edu.nbu.cn.bizcache.core.registry;

import com.edu.nbu.cn.bizcache.core.entity.CacheKey;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

@Component
public class CacheKeyRegistry {

    private  final Map<Object, CacheKey> cacheKeyRegistry = new WeakHashMap<>();


    public void registerCacheKey(CacheKey cacheKey){
        if(Objects.isNull(cacheKey)){
            return ;
        }
        cacheKeyRegistry.putIfAbsent(cacheKey.getCacheId(),cacheKey);
    }

    public CacheKey getCacheKey(Object obj){
        return cacheKeyRegistry.get(obj);
    }
}
