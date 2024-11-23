package com.edu.nbu.cn.hippo;

/**
 * @author laoshi . hua
 * @version 1.0 2023/7/28-4:28 PM
 * @since 1.0
 */
public class StackTraceElementDemo {
    public static void main(String[] args) {
        append("main");
        StackTraceElement[] stts = Thread.currentThread().getStackTrace();
        System.out.println("first stackTrace : " + stts[0].toString());

        for(StackTraceElement stt : stts){
            System.out.println(stt.toString());
        }

    }

    public static String append(String s){
        StringBuilder sb = new StringBuilder("xx");
        return sb.append(s).toString();
    }
}
