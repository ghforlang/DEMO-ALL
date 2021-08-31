package com.edu.nbu.cn.beancopy.orikademo;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class PollutantSourceDTO {
    private String      id;
    private List<Xzqh2> xzqhs2; //递归测试，集合泛型测试
    private String      orgCode; //非同名测试
    private Long        gmtCreated; //类型转换
    private String gmtModified;
    private String[]    addresses; //List & Array
    private Geo         geo;
}
