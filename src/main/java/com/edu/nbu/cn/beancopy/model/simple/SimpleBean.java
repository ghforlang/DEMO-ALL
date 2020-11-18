package com.edu.nbu.cn.beancopy.model.simple;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SimpleBean implements Cloneable{
    private Long id;
    private String uuid;
    private String name;

    public static SimpleBean instance(){
        SimpleBean simpleBean = new SimpleBean();
        simpleBean.setId(12321L);
        simpleBean.setName("simpleBean");
        simpleBean.setUuid("123135alxojgoasfl2os");
        return simpleBean;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
