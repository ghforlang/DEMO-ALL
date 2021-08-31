package com.edu.nbu.cn.designpattern.builder;

import com.alibaba.fastjson.JSON;

/**
 *
 * @version 1.0
 * @Date 2021/2/22 7:47 下午
 * @since 1.0
 */
public class TestBuilder {

    public static void main(String[] args) {
        MyBeanFactory.MyBeanBuilder builder = new MyBeanFactory.MyBeanBuilder()
                .id("1")
                .name("builder-test")
                .beanName("test-bean");
        MyBean bean = builder.build();
        System.out.println(JSON.toJSON(bean));
    }
}
