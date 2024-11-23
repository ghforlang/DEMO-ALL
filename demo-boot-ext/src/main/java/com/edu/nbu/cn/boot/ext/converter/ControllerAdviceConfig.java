package com.edu.nbu.cn.boot.ext.converter;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author laoshi . hua
 * @version 1.0 2023/2/1-6:15 PM
 * @since 1.0
 */
//@ControllerAdvice
//@RestControllerAdvice
public class ControllerAdviceConfig {
    private static final SimpleDateFormat timeFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

//    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        dataBinder.registerCustomEditor(Date.class,new PropertyEditorSupport(){
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                try {
                    setValue(timeFormatter.parse(text));
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
