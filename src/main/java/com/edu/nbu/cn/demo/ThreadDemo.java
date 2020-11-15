package com.edu.nbu.cn.demo;

import java.util.concurrent.TimeUnit;

public class ThreadDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new MyThread[10];

        for(int i=0;i<10;i++){
            threads[i] = new MyThread(i + "");
        }

        for(int i=0;i<10;i++){
            threads[i].start();
        }

        for (int i=0;i<10;i++){
            threads[i].join();
        }
        System.out.println("main thread!");
    }

    static class MyThread extends Thread{
        private String name;

        public MyThread(String name){
            this.name = name;
        }

        @Override
        public void run() {
            super.run();

//            try {
//                TimeUnit.MILLISECONDS.sleep(1000L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(name + " is running");
        }
    }
}
