package com.edu.nbu.cn.beancopy.orikademo;

import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class LocalDateTime2LongConverter extends BidirectionalConverter<LocalDateTime,Long> {

    @Override
    public Long convertTo(LocalDateTime localDateTime, Type<Long> type, MappingContext mappingContext) {
        return localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }

    @Override
    public LocalDateTime convertFrom(Long aLong, Type<LocalDateTime> type, MappingContext mappingContext) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(aLong), ZoneOffset.of("+8").normalized());
    }
}
