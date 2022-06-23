package com.edu.nbu.cn.spring.function.core.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author laoshi . hua
 * @version 1.0 2022/6/18-6:27 PM
 * @since 1.0
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface FunctionMethod {
    /**
     * 策略标识
     * @return
     */
    String identifier() default "";
}
