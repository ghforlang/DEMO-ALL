package com.edu.nbu.cn.bizcache.anno;

import com.edu.nbu.cn.bizcache.Operation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface UseCache {

    /**
     * 操作，默认查询
     * @return
     */
    Operation operation() default Operation.QUERY;
}
