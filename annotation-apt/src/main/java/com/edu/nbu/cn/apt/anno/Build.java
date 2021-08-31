package com.edu.nbu.cn.apt.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @version 1.0
 * @Date 2021/8/3 8:08 下午
 * @since 1.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS)
public @interface Build {

    /**
     * 被注解元素类型
     * @return
     */
    Class<?> type();

    /**
     * 业务id
     * @return
     */
    String bizId();

    /**
     * 所属组
     * @return
     */
    String group() default "default";
}
