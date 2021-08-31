package com.edu.nbu.cn.beancopy.model;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public enum CourseEnum {
    YUWEN(1,"语文"),SHUXUE(2,"数学"),YIGNYU(3,"英语");
    private Integer courseType;
    private String courseName;

    CourseEnum(Integer courseType, String courseName) {
        this.courseType = courseType;
        this.courseName = courseName;
    }

    public static CourseEnum getByType(Integer type){
        if(Objects.isNull(type)){
            return null;
        }

        for(CourseEnum value :  CourseEnum.values()){
            if(value.courseType == type){
                return value;
            }
        }
        return null;
    }

    public static CourseEnum getByName(String courseName){
        if(StringUtils.isBlank(courseName)){
            return null;
        }

        for(CourseEnum value :  CourseEnum.values()){
            if(value.courseName.equalsIgnoreCase(courseName)){
                return value;
            }
        }
        return null;
    }

    public Integer getCourseType() {
        return courseType;
    }

    public String getCourseName() {
        return courseName;
    }
}
