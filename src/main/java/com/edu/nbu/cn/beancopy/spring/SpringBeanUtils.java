package com.edu.nbu.cn.beancopy.spring;

import org.springframework.beans.BeanUtils;

public class SpringBeanUtils {

    public static void copy (Object src,Object dest){
        BeanUtils.copyProperties(src,dest);
    }
}
