package com.edu.nbu.cn.demo.problem;

/**
 *
 * @version 1.0
 * @Date 2021/3/18 5:38 下午
 * @since 1.0
 */
public class ClassA {

    private final static boolean REPLICATE_PROBLEM1 = true; // static variable initializer
    private final static boolean REPLICATE_PROBLEM2 = false; // static block{} initializer

    // Static variable executed at Class loading time
    private static String staticVariable = initStaticVariable();

    // Static initializer block executed at Class loading time
    static {

        // Static block code execution...
        if (REPLICATE_PROBLEM2) throw new IllegalStateException("ClassA.static{}: Internal Error!");
    }

    public ClassA() {
        System.out.println("Creating a new instance of "+ClassA.class.getName()+"...");
    }

    /**
     *
     * @return
     */
    private static String initStaticVariable() {

        String stringData = "";

        if (REPLICATE_PROBLEM1) throw new IllegalStateException("ClassA.initStaticVariable(): Internal Error!");

        return stringData;
    }
}
