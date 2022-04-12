package com.edu.nbu.fan.gen.anno;


import com.edu.nbu.fan.gen.contants.TableType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
* @author laoshi . hua
* @since 1.0 
* @version 1.0 2022/3/23-8:36 下午
*/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Transfer {

    TableType sourceType();

    String tableName();
}
