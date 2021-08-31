package com.edu.nbu.cn.designpattern.builder;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @version 1.0
 * @Date 2021/2/22 7:37 下午
 * @since 1.0
 */
@Data
@AllArgsConstructor
public class MyBean {

   private Person person;
   private String beanName;

    public MyBean(MyBeanFactory.MyBeanBuilder myBeanBuilder){
        this.person = new Person(myBeanBuilder.getId(), myBeanBuilder.getName());
        this.beanName = myBeanBuilder.getBeanName();
    }

}
