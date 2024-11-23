package com.edu.nbu.fan.dubbo.advance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Function;

/**
 * @author laoshi . hua
 * @version 1.0 2022/10/21-5:55 PM
 * @since 1.0
 */
public class InvokerProxy<S,T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(InvokerProxy.class);

    public <S,T> T  invoke(Function<S,T> function, S arg){
        try{
            return function.apply(arg);
        }catch (Exception ex){
            LOGGER.error(ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
    }
}
