package com.edu.nbu.cn.beancopy.orika.converter.property;

import com.edu.nbu.cn.beancopy.orika.core.OrikaRegisterCommonConverter;
import com.edu.nbu.cn.beancopy.model.CourseEnum;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.metadata.Type;

import java.util.Objects;

public class CourseType2NameConverter extends OrikaRegisterCommonConverter<Integer,String> {

    private static final CourseType2NameConverter instance = new CourseType2NameConverter();

    @Override
    public String convertTo(Integer integer, Type<String> type, MappingContext mappingContext) {
        return Objects.isNull(CourseEnum.getByType(integer)) ? "未知" : CourseEnum.getByType(integer).getCourseName();
    }

    @Override
    public Integer convertFrom(String s, Type<Integer> type, MappingContext mappingContext) {
        return Objects.isNull(CourseEnum.getByName(s)) ? null : CourseEnum.getByName(s).getCourseType();
    }

    public static CourseType2NameConverter newInstance(){
        return instance;
    }
}
