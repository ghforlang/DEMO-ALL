package com.edu.nbu.cn.bizcache.core;

import com.edu.nbu.cn.bizcache.core.entity.CacheData;

public interface CacheFacade {

    /**
     * 缓存数据
     * @param data
     * @param <T>
     * @return
     */
    <T> void cache(CacheData<T> data);

    /**
     *
     */
    <T> T getCache();
}
