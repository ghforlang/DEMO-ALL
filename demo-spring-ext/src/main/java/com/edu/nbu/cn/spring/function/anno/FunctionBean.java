package com.edu.nbu.cn.spring.function.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author laoshi . hua
 * @version 1.0 2022/6/18-5:54 PM
 * @since 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface FunctionBean {
//    /**
//     * 策略标识
//     * @return
//     */
//    String identifier();
}
