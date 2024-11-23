package com.edu.nbu.cn.boot.ext.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author laoshi . hua
 * @version 1.0 2023/2/1-11:21 AM
 * @since 1.0
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex){
        if(ex instanceof NumberFormatException){
            log.info("数据转换异常,msg:{}",ex.getMessage());
            return "数据转换异常,msg:" + ex.getMessage();
        }else if(ex instanceof ArrayIndexOutOfBoundsException){
            log.info("数组越界异常,msg:{}",ex.getMessage());
            return "数组越界异常,msg:" + ex.getMessage();
        }else if(ex instanceof ArithmeticException){
            log.info("非法参数异常,msg:{}",ex.getMessage());
            return "非法参数异常,msg:" + ex.getMessage();
        }else{
            log.info("其他异常,msg:{}",ex);
            return "其他异常,msg:" + ex.getStackTrace();
        }
    }
}
