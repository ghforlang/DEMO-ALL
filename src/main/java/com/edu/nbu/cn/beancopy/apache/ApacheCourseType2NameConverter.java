package com.edu.nbu.cn.beancopy.apache;

import com.edu.nbu.cn.beancopy.model.CourseEnum;

import java.util.Objects;

public class ApacheCourseType2NameConverter extends ApacheBaseConverter {

    private static class Singleton{
        private static ApacheCourseType2NameConverter instance = new ApacheCourseType2NameConverter();
    }


    @Override
    protected Object convertToType(Class type, Object value) throws Throwable {
        if(!type.equals(String.class)){
            return null;
        }

        CourseEnum courseEnum = CourseEnum.getByType(value instanceof Integer ? (Integer)value : null);
        return Objects.isNull(courseEnum) ? value : courseEnum.getCourseName();
    }

    @Override
    protected Class getDefaultType() {
        return String.class;
    }

    @Override
    public String convert(Class aClass, Object o) {
        if(!aClass.equals(String.class) || !(o instanceof Integer)){
            return o.toString();
        }

        CourseEnum courseEnum = CourseEnum.getByType(o instanceof Integer ? (Integer)o : null);
        return Objects.isNull(courseEnum) ? null : courseEnum.getCourseName();
    }

    public static ApacheCourseType2NameConverter getConverter() {
        return Singleton.instance;
    }
}
