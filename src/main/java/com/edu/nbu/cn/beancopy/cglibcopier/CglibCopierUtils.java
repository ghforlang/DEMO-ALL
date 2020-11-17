package com.edu.nbu.cn.beancopy.cglibcopier;

import net.sf.cglib.beans.BeanCopier;

public class CglibCopierUtils {

    public static Object copy(Class<?> srcClass,Class<?> tarClass,Object src,Object tar){
        BeanCopier copier = BeanCopier.create(srcClass,tarClass,false);
        copier.copy(src,tar,null);
        return tar;
    }

}
