package com.edu.nbu.cn.beancopy.apache;

import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ApacheLocalDateTime2FormatStringConverter extends ApacheBaseConverter {

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss SSS", Locale.CHINA);

    private static class Singleton{
        private static ApacheLocalDateTime2FormatStringConverter instance = new ApacheLocalDateTime2FormatStringConverter();
    }

    @Override
    protected Object convertToType(Class type, Object value) throws Throwable {
        if(!type.equals(String.class) || !(value instanceof LocalDateTime)){
            return value.toString();
        }
        LocalDateTime localDateTime = (LocalDateTime)value;
        return localDateTime.format(dateTimeFormatter);
    }

    @Override
    protected Class getDefaultType() {
        return String.class;
    }

    @Override
    public String convert(Class aClass, Object o) {
        if(!aClass.equals(String.class)){
            return null;
        }
        LocalDateTime localDateTime = (LocalDateTime)o;
        return localDateTime.format(dateTimeFormatter);
    }

    public static ApacheLocalDateTime2FormatStringConverter getConverter() {
        return Singleton.instance;
    }
}
