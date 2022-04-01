package com.edu.nbu.cn.datatransfer.core.source;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/25-3:23 下午
 * @since 1.0
 */
public interface StageResource {

    String sourceName();

    boolean hasResult();

    String sourceType();
}
