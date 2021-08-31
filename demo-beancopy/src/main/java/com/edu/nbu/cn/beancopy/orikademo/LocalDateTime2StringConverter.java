package com.edu.nbu.cn.beancopy.orikademo;

import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTime2StringConverter extends BidirectionalConverter<LocalDateTime,String> {

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public String convertTo(LocalDateTime localDateTime, Type<String> type, MappingContext mappingContext) {
        return localDateTime.format(dateTimeFormatter);
    }

    @Override
    public LocalDateTime convertFrom(String s, Type<LocalDateTime> type, MappingContext mappingContext) {
        return LocalDateTime.parse(s,dateTimeFormatter);
    }
}
