package com.edu.nbu.cn.beancopy.dozer.converter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DozerLocalDateTime2StringConverter extends BaseDozerConverter<LocalDateTime,String> {

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public  DozerLocalDateTime2StringConverter(){
        super(LocalDateTime.class,String.class);
    }


    @Override
    public String convertTo(LocalDateTime source) {
        return source.format(dateTimeFormatter);
    }

    @Override
    public LocalDateTime convertFrom(String source) {
        return LocalDateTime.parse(source,dateTimeFormatter);
    }

    @Override
    public String convertTo(LocalDateTime localDateTime, String s) {
        return convertTo(localDateTime);
    }

    @Override
    public LocalDateTime convertFrom(String s, LocalDateTime localDateTime) {
        return convertFrom(s);
    }

}
