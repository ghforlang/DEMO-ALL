package com.edu.nbu.fan.gen.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/23-8:20 下午
 * @since 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface TransferColumn {
    boolean transfer() default true;

    String tarColumnValue() default "";
    String tarColumnName() default "";
}
