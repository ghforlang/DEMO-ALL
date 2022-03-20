package com.edu.nbu.bean;


import com.edu.nbu.bean.model.TestBean;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/16-5:07 下午
 * @since 1.0
 */
public class CustomPropertyDescriptor {

    public static void main(String[] args) throws IntrospectionException {
        PropertyDescriptor nameDescriptor = new PropertyDescriptor("name", TestBean.class);
        System.out.println();
        PropertyDescriptor ageDescriptor = new PropertyDescriptor("age", TestBean.class);
        PropertyDescriptor beanDescriptor = new PropertyDescriptor("bean", TestBean.class);

    }
}
