package com.edu.nbu.cn.designpattern.builder;

import lombok.Getter;

/**
 *
 * @version 1.0
 * @Date 2021/2/22 7:36 下午
 * @since 1.0
 */
public class MyBeanFactory {

    public static MyBeanBuilder builder(){
        return new MyBeanBuilder();
    }

    public static MyBean newMyBean(String beanName,String id,String name){
        return new MyBean(new Person(id,name),beanName);
    }


    /**
     * 适用于构造复杂对象，非常方便
     */
    @Getter
    public static class MyBeanBuilder {

        private String id;
        private String name;
        private String beanName;


        public MyBean build(){
            return new MyBean(this);
        }

        public MyBeanBuilder id(String id){
            this.id = id;
            return this;
        }

        public MyBeanBuilder name(String name){
            this.name = name;
            return this;
        }

        public MyBeanBuilder beanName(String beanName){
            this.beanName = beanName;
            return this;
        }
    }
}
