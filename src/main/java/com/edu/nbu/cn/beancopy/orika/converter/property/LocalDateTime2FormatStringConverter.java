package com.edu.nbu.cn.beancopy.orika.converter.property;


import com.edu.nbu.cn.beancopy.orika.core.OrikaRegisterCommonConverter;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.metadata.Type;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LocalDateTime2FormatStringConverter extends OrikaRegisterCommonConverter<LocalDateTime,String> {

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss SSS", Locale.CHINA);
    private static final LocalDateTime2FormatStringConverter instance = new LocalDateTime2FormatStringConverter();
    @Override
    public String convertTo(LocalDateTime localDateTime, Type<String> type, MappingContext mappingContext) {
        return localDateTime.format(dateTimeFormatter);
    }

    @Override
    public LocalDateTime convertFrom(String localDateTime, Type<LocalDateTime> type, MappingContext mappingContext) {
        return LocalDateTime.parse(localDateTime,dateTimeFormatter);
    }

    public static LocalDateTime2FormatStringConverter newInstance(){
        return instance;
    }
}
