package com.edu.nbu.cn.boot.ext.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author laoshi . hua
 * @version 1.0 2023/2/1-1:53 PM
 * @since 1.0
 */
@Component
public class BirthdayConverter implements Converter<String, Date> {

    private static final SimpleDateFormat timeFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    public Date convert(String source) {
        try {
            return timeFormatter.parse(source);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
