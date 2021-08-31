package com.edu.nbu.cn.beancopy.cglibcopier;

import com.edu.nbu.cn.beancopy.model.simple.SimpleBean;
import com.edu.nbu.cn.beancopy.model.simple.SimpleBeanDTO;
import net.sf.cglib.beans.BeanCopier;
import net.sf.cglib.core.DebuggingClassWriter;

public class CglibCopierUtils {

    private static SimpleBean simpleBean = SimpleBean.instance();

    public static Object copy(Class<?> srcClass,Class<?> tarClass,Object src,Object tar){
        BeanCopier copier = BeanCopier.create(srcClass,tarClass,false);
        copier.copy(src,tar,null);
        return tar;
    }


    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "E:\\workspace\\JVM-OOM\\reflection\\com\\edu\\nbu\\cn\\demo\\reflection");
        SimpleBeanDTO beanDTO = new SimpleBeanDTO();
        copy(SimpleBean.class, SimpleBeanDTO.class,simpleBean,beanDTO);
    }
}
