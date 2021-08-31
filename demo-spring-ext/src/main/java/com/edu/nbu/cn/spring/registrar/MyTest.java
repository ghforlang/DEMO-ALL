package com.edu.nbu.cn.spring.registrar;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @version 1.0
 * @Date 2021/2/3 11:46 上午
 * @since 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE,ElementType.FIELD})
public @interface MyTest {
    String value() default "test";
}
