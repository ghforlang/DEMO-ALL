package com.edu.nbu.cn.beancopy.orika.core;


import com.edu.nbu.cn.beancopy.orika.converter.property.CourseType2NameConverter;
import com.edu.nbu.cn.beancopy.orika.converter.property.LocalDateTime2FormatStringConverter;

public enum OrikaConverterEnum {
    LOCAL_DATATIME_2_FORMAT_STRING("localDateTime2FormatStringConverter", LocalDateTime2FormatStringConverter.newInstance()),
    COURSE_TYPE_2_NAME("courseType2NameConverter", CourseType2NameConverter.newInstance());

    private String coverterId;
    private OrikaRegisterCommonConverter converter;

    OrikaConverterEnum(String coverterId, OrikaRegisterCommonConverter converter) {
        this.coverterId = coverterId;
        this.converter = converter;
    }

    public String getCoverterId() {
        return coverterId;
    }

    public OrikaRegisterCommonConverter getConverter() {
        return converter;
    }
}
