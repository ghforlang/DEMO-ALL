package com.edu.nbu.cn.caffeine.model;

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


    public static Person instance(String name){
        return new Person(name);
    }
}
