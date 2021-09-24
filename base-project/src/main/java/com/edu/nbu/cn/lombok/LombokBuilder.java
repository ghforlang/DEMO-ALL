package com.edu.nbu.cn.lombok;

import lombok.Builder;

//@Builder(builderClassName="Builder")
@Builder
public class LombokBuilder {
    private String name;
    @Builder.ObtainVia(method = "generateAge")
    private Integer age;
}
