package com.edu.nbu.cn.demo;

/**
 *
 * @version 1.0
 * @Date 2021/7/5 5:18 下午
 * @since 1.0
 */
public class Singleton {
    private static Singleton INSTANCE;

    public Singleton(){
        INSTANCE = this;
    }

    public static Singleton getInstance(){
        if(INSTANCE == null){
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            for (int i=0;i<10;i++){
                    System.out.println(getInstance());
            }
        },"t1");
        Thread t2 = new Thread(() ->{
            for (int i=0;i<10;i++){
                    System.out.println(getInstance());
            }
        },"t2");

        t1.start();
        t2.start();
    }

}
