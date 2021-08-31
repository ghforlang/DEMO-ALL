package com.edu.nbu.cn.stream;

import org.apache.commons.lang3.StringUtils;

import java.util.stream.IntStream;

/**
 *
 * @version 1.0
 * @Date 2021/3/24 5:23 下午
 * @since 1.0
 */
public class IntStreamDemo {
    public static IntStream INT_STREAM  = IntStream.of(1,2,3);

    public static void main(String[] args) {
        System.out.println(INT_STREAM);
        System.out.println(INT_STREAM.boxed());
        resetStream();
        System.out.println("sum : " + INT_STREAM.sum());
        resetStream();
        int[] intArray = INT_STREAM.toArray();
        for(int i =0;i<intArray.length ; i++){
            System.out.println(intArray[i]);
        }
        resetStream();
        System.out.println("count : " + INT_STREAM.count());
        resetStream();
        System.out.println("average : " + INT_STREAM.average().getAsDouble());
        resetStream();
        System.out.println("max: " + INT_STREAM.max().getAsInt());
        resetStream();
        System.out.println("Statistics-average : " + INT_STREAM.summaryStatistics().getAverage());
        resetStream();
        System.out.println("Statistics-count : " + INT_STREAM.summaryStatistics().getCount());
        resetStream();
        System.out.println("Statistics-max : " + INT_STREAM.summaryStatistics().getMax());
        resetStream();
        System.out.println("Statistics-min : " + INT_STREAM.summaryStatistics().getMin());
        resetStream();
        System.out.println("Statistics-sum : " + INT_STREAM.summaryStatistics().getSum());

    }

    private static void resetStream(){
        INT_STREAM  = IntStream.of(1,2,3);
    }

}
