package com.edu.nbu.cn.demo.problem;

/**
 *
 * @version 1.0
 * @Date 2021/3/18 5:28 下午
 * @since 1.0
 */
public class TestProblem {



    public static void main(String[] args) {
//       testEnum();
        testGeneralClass();
    }

    private static void testEnum(){
        for(WrongEnum wrong : WrongEnum.values()){
            System.out.println(wrong.getValue() + wrong.getDesc().toString());
        }
    }

    private static void testGeneralClass(){
        System.out.println("java.lang.NoClassDefFoundError Simulator - Training 2");
        System.out.println("Author: Pierre-Hugues Charbonneau");
        System.out.println("http://javaeesupportpatterns.blogspot.com\n\n");

        try {
            // Create a new instance of ClassA (attempt #1)
            System.out.println("FIRST attempt to create a new instance of ClassA...\n");
            ClassA classA = new ClassA();

        } catch (Throwable any) {
            any.printStackTrace();
        }

        try {
            // Create a new instance of ClassA (attempt #2)
            System.out.println("\nSECOND attempt to create a new instance of ClassA...\n");
            ClassA classA = new ClassA();

        } catch (Throwable any) {
            any.printStackTrace();
        }

        try {
            // Create a new instance of ClassA (attempt #3)
            System.out.println("\nTHIRD attempt to create a new instance of ClassA...\n");
            ClassA classA = new ClassA();

        } catch (Throwable any) {
            any.printStackTrace();
        }

        System.out.println("\n\ndone!");
    }
}
