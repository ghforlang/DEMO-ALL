package com.edu.nbu.cn.bizcache.core.entity;

public interface CacheData<T> {

    /**
     * 缓存数据获取
     * @param <T>
     * @return
     */
     <T> T getData();
}
