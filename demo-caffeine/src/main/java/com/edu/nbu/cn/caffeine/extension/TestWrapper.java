package com.edu.nbu.cn.caffeine.extension;

import com.edu.nbu.cn.caffeine.model.Person;

/**
 *
 * @version 1.0
 * @Date 2021/3/5 3:22 下午
 * @since 1.0
 */
public class TestWrapper {

    public static void main(String[] args) {
//        String key = "张三";
//        printPerson(v -> build(v));
        Person p1 = Person.instance("zhangsan");
        Person p2 = p1;
        p1.setName("lisi");
        System.out.println(p2);
    }

    private static Address build(String s){
        Address address = new Address();
        address.setName(s);
        return address;
    }

    public static void printAddress(Address address){
        System.out.println(address.toString());
    }


}
