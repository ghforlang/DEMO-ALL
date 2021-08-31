package com.edu.nbu.cn.stackoverflow;

public class TestStackOverFlow {
    private static int index = 1;

    //打印栈深度，JVM规范规定不超过65535，值随机，不固定
    public static void main(String[] args) {
        TestStackOverFlow tsof = new TestStackOverFlow();
        try{
            tsof.method();
        }catch (Throwable e){
            System.out.println("stack deep : " + index);
            e.printStackTrace();
        }
    }


    public void method(){
        index ++;
        method();
    }


}
