package com.edu.nbu.cn;

public class TestStaticOverride {

    public static void main(String[] args) {
//        SubTestStatic subTestStatic = new SubTestStatic();
//        SubTestStatic.testStatic1();
        Integer value = 1;

        System.out.println(value == TestStatic.v);
    }

    //非静态方法内部，不支持静态变量，编译无法通过
    public void testStatic(){
//        static int num = 0;
    }
}


class TestStatic {
   static  Integer v = 1;

    private static void testStatic(){
        System.out.println("this is private testStatic");
    }

    public static void testStatic1(){
        System.out.println("this is public testStatic");
    }
}

class  SubTestStatic extends  TestStatic{

    private static void testStatic(){
        System.out.println("this is private  subTestStatic");
    }

    public static void testStatic1(){
        System.out.println("this is public subTestStatic");
    }
}
