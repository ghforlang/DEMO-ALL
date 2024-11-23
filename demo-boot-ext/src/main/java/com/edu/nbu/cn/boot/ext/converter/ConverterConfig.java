package com.edu.nbu.cn.boot.ext.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author laoshi . hua
 * @version 1.0 2023/2/1-1:56 PM
 * @since 1.0
 */
//@Configuration
public class ConverterConfig extends WebMvcConfigurerAdapter {

//    @Bean
//    public Converter<String, Date> converter(){
//        return new BirthdayConverter();
//    }
//
//    @Bean
//    public ObjectMapper objectMapper(){
//        ObjectMapper objectMapper = new ObjectMapper();
//
////        objectMapper.registerModule();
//        return objectMapper;
//    }

    @Bean
    public GenericConversionService genericConversionService(){
        return new GenericConversionService();
    }

    @Bean
    public BirthdayConversionService birthdayConversionService(){
        BirthdayConversionService birthdayConversionService  = new BirthdayConversionService();
        Set<Converter<?,?>> converters = new HashSet<>();
        converters.add(new BirthdayConverter());
        birthdayConversionService.setConverters(converters);
        return birthdayConversionService;
    }

//    @Bean
    public ConversionServiceFactoryBean conversionServiceFactoryBean(){
        ConversionServiceFactoryBean conversionServiceFactoryBean = new ConversionServiceFactoryBean();
        Set<Converter> converters = new HashSet<>();
        converters.add(new BirthdayConverter());
        conversionServiceFactoryBean.setConverters(converters);
        return conversionServiceFactoryBean;
    }
}
