package com.edu.nbu.cn.bizcache;

public enum Operation {
    /**
     * 查询
     */
    QUERY,

    /**
     * 查询 后更新
     */
    QUERY_REFRESH,

    /**
     * 刷新
     */
    REFRESH,

    /**
     * 清除
     */
    CLEAR;
}
