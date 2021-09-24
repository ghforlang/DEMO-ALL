package com.edu.nbu.cn.lombok;


import lombok.NonNull;

@NonNull
public class LombokNotNull {

    private @NonNull String name;
    private Integer age;

    public String computeAge(@NonNull Integer age){
        return age + "岁";
    }
}
