package com.edu.nbu.cn.lombok;

import lombok.Data;


// @Data = getter/setter/equal/toString
// extra: staticConstructor,与@AllArgsConstructor互斥
@Data(staticConstructor = "valueOf")
public class LombokData {

    private String name;
    private Integer age;
}
