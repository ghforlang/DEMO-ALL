package com.edu.nbu.cn.stream;

import java.util.Optional;

import static com.edu.nbu.cn.stream.constant.Constants.*;

/**
 *
 * @version 1.0
 * @Date 2021/3/24 8:01 下午
 * @since 1.0
 */
public class SimpleDemo {

    public static void main(String[] args) {
        //跟踪map执行过程，无状态操作，
        Optional<String> optional = COMMON_STREAM.map(v -> v + 2).findFirst();
        resetStream();
        COMMON_STREAM.forEach(v -> System.out.println(v));



        //跟踪sorted执行过程，有状态操作

        //跟踪foreach操作，无状态

    }

    private static void resetStream(){
        COMMON_STREAM = COMMON_STR_LIST.stream();
    }
}
