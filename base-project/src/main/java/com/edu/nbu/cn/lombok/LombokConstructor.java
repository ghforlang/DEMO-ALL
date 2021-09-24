package com.edu.nbu.cn.lombok;


import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "valueOf")
public class LombokConstructor {

    @NonNull
    private String name;
    private Integer age;
}
