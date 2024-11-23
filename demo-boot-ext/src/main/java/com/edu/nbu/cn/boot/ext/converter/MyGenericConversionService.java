package com.edu.nbu.cn.boot.ext.converter;

import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.core.convert.converter.ConverterRegistry;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.core.convert.support.GenericConversionService;

/**
 * @author laoshi . hua
 * @version 1.0 2023/2/2-2:23 PM
 * @since 1.0
 * @see GenericConversionService
 */
public class MyGenericConversionService implements ConversionService, ConverterRegistry {

    @Override
    public boolean canConvert(Class<?> sourceType, Class<?> targetType) {
        return false;
    }

    @Override
    public boolean canConvert(TypeDescriptor sourceType, TypeDescriptor targetType) {
        return false;
    }

    @Override
    public <T> T convert(Object source, Class<T> targetType) {
        return null;
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        return null;
    }

    @Override
    public void addConverter(Converter<?, ?> converter) {

    }

    @Override
    public <S, T> void addConverter(Class<S> sourceType, Class<T> targetType, Converter<? super S, ? extends T> converter) {

    }

    @Override
    public void addConverter(GenericConverter converter) {

    }

    @Override
    public void addConverterFactory(ConverterFactory<?, ?> factory) {

    }

    @Override
    public void removeConvertible(Class<?> sourceType, Class<?> targetType) {

    }
}
