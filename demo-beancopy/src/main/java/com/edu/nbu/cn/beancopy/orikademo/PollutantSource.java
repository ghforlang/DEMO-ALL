package com.edu.nbu.cn.beancopy.orikademo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
public class PollutantSource {

    private String        id;
    private List<Xzqh>    xzqhs;  //递归测试，集合泛型测试
    private String        socialCode; //非同名测试
    private LocalDateTime gmtCreated; //类型转换
    private LocalDateTime gmtModified;
    private List<String> addresses;  //List & Array
    /* 导航属性 */
    private String        latitude;
    private String        longitude;
}
