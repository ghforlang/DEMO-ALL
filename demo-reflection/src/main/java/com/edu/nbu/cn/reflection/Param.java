package com.edu.nbu.cn.reflection;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Param {

    /**
     * 姓名
     */
    private String name;

    /***
     * 住址
     */
    private String address;

    /**
     * 年龄
     */
    private Integer age;

}
