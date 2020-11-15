package com.edu.nbu.cn.demo.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class StudentReflectionHelper {

    public static Student create(Param param) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Student s = Student.class.newInstance();
        Method[] paramMethods = Param.class.getDeclaredMethods();
        Method[] studentMethods =  Student.class.getDeclaredMethods();
        for(Method method : studentMethods){
            Object value = null;
            if(method.getName().startsWith("set")){
                String fieldName = method.getName().substring(3);
                fieldName = fieldName.substring(0,1).toLowerCase() + fieldName.substring(1);
                for(Method method1 : paramMethods){
                    if(method1.getName().startsWith("get")){
                        String getFieldName = method1.getName().substring(3);
                        getFieldName = getFieldName.substring(0,1).toLowerCase() + getFieldName.substring(1);
                        if(fieldName.equals(getFieldName)){
                            value = method1.invoke(param);
                        }
                    }
                }
                method.invoke(s,value);
            }
        }
         return s;
    }

}
