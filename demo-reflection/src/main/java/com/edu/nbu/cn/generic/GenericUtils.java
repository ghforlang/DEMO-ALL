package com.edu.nbu.cn.generic;

import com.edu.nbu.cn.generic.model.Wrapper;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author laoshi . hua
 * @version 1.0 2023/5/25-10:19 AM
 * @since 1.0
 */
public class GenericUtils {

    public static <T> Class<T> getGenericClass(T obj){
        return (Class<T>) obj.getClass();
    }


    public static <T> Type getGenericRuntimeType(Wrapper<T> wrapper){
        Type type = wrapper.getClass().getGenericSuperclass();
        if(type == null){
            return null;
        }

        if(type instanceof ParameterizedType){
            Type[] types = ((ParameterizedType) type).getActualTypeArguments();
            return types[0];
        }
        return null;
    }
}
