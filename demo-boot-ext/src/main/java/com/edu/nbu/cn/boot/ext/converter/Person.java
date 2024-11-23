package com.edu.nbu.cn.boot.ext.converter;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author laoshi . hua
 * @version 1.0 2023/2/1-1:51 PM
 * @since 1.0
 */
@Getter
@Setter
public class Person {
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;

    /**
     * 出生日期,格式：yyyy-MM-dd HH:mm:ss
     */
//    DateTimeFormat不好使
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;
}
