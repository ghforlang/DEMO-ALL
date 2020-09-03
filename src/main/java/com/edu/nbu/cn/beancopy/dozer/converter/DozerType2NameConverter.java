package com.edu.nbu.cn.beancopy.dozer.converter;

import com.edu.nbu.cn.beancopy.model.CourseEnum;

import java.util.Objects;

public class DozerType2NameConverter extends BaseDozerConverter<Integer,String>{

    public DozerType2NameConverter() {
        super(Integer.class, String.class);
    }

    @Override
    public String convertTo(Integer source) {
        return Objects.isNull(CourseEnum.getByType(source)) ? "未知" : CourseEnum.getByType(source).getCourseName();
    }

    @Override
    public Integer convertFrom(String source) {
        return Objects.isNull(CourseEnum.getByName(source)) ? null : CourseEnum.getByName(source).getCourseType();
    }

    @Override
    public String convertTo(Integer integer, String s) {
        return convertTo(integer);
    }

    @Override
    public Integer convertFrom(String s, Integer integer) {
        return convertFrom(s);
    }

}
