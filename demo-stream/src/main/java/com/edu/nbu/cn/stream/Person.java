package com.edu.nbu.cn.stream;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Person {

    private String name;
    private Integer gender;
    private Integer age;

    public static Person of(String name,Integer degree,Integer age){
        return new Person(name,degree,age);
    }
}
