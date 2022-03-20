package com.edu.nbu.cn.datatransfer.generator;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/18-2:34 下午
 * @since 1.0
 */

public interface Generator<S,T> {

    /**
     * 根据源source生成目标资源
     * @param s
     * @param <T>
     * @return
     */
    <T> T generator(S s);
}
