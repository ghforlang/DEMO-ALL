package com.edu.nbu.cn.boot.ext.converter;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.core.convert.support.GenericConversionService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

/**
 * @author laoshi . hua
 * @version 1.0 2023/2/6-3:38 PM
 * @since 1.0
 * @desc 可以服用genericConversionService的一些功能
 */

public class BirthdayConversionService implements ConversionService, InitializingBean {

    @Resource
    private GenericConversionService genericConversionService;

    public Set<?> getConverters() {
        return converters;
    }

    public void setConverters(Set<?> converters) {
        this.converters = converters;
    }

    private Set<?> converters;

    @Override
    public boolean canConvert(Class<?> sourceType, Class<?> targetType) {
        return sourceType.equals(String.class) && targetType.equals(Date.class);
    }

    @Override
    public boolean canConvert(TypeDescriptor sourceType, TypeDescriptor targetType) {
        return sourceType.getClass().equals(String.class) && targetType.getClass().equals(Date.class);
    }

    @Override
    public <T> T convert(Object source, Class<T> targetType) {
        return genericConversionService.convert(source,targetType);
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        return genericConversionService.convert(source,sourceType,targetType);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if(Objects.nonNull(converters) && converters.size() > 0){
            converters.forEach(object ->{
                if(object instanceof  Converter<?,?>){
                    genericConversionService.addConverter((Converter<?, ?>) object);
                }else if (object instanceof ConverterFactory<?,?>){
                    genericConversionService.addConverterFactory((ConverterFactory<?,?>)object);
                }else if (object instanceof GenericConverter){
                    genericConversionService.addConverter((GenericConverter)object);
                }
            });
        }
    }
}
