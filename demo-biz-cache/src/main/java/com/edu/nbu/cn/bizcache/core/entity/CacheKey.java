package com.edu.nbu.cn.bizcache.core.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CacheKey {

    /**
     * 唯一id
     */
    private Object cacheId;

    /**
     * 标识
     */
    private String identifier;

    /**
     * 缓存值 class
     */
    private Class<?> cachedClass;
}
