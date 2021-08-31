package com.edu.nbu.cn.stream.constant;

import com.edu.nbu.cn.stream.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 *
 * @version 1.0
 * @Date 2021/3/24 11:02 上午
 * @since 1.0
 */
public class Constants {

    public static final List<String> COMMON_STR_LIST = new ArrayList<>();
    public static final List<Integer> COMMON_INT_LIST = new ArrayList<>();
    public static final Map<String,Integer> COMMON_MAP = new HashMap<>();
    public static final List<Person> COMMON_PERSON_LIST = new ArrayList<>();

    public static  Stream<String> COMMON_STREAM =  COMMON_STR_LIST.stream();

    static {
        COMMON_STR_LIST.add("a");
        COMMON_STR_LIST.add("b");
        COMMON_STR_LIST.add("c");

        COMMON_INT_LIST.add(1);
        COMMON_INT_LIST.add(2);
        COMMON_INT_LIST.add(3);
        COMMON_INT_LIST.add(4);
        COMMON_INT_LIST.add(5);
        COMMON_INT_LIST.add(6);
        COMMON_INT_LIST.add(7);
        COMMON_INT_LIST.add(8);
        COMMON_INT_LIST.add(9);


        COMMON_MAP.put("a",1);
        COMMON_MAP.put("b",2);
        COMMON_MAP.put("c",3);

        COMMON_PERSON_LIST.add(Person.of("张三",1,20));
        COMMON_PERSON_LIST.add(Person.of("里斯",2,30));
        COMMON_PERSON_LIST.add(Person.of("王武",1,20));
    }
}
