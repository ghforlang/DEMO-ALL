package com.edu.nbu.cn;


import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {

    // semaphore 用于限流,有bug，若出现异常则会释放许可，导致限流失败
    public  void limitFlow(){
        Semaphore semaphore = new Semaphore(10);
        try {
            semaphore.acquire();
            doSomething(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
    }

    // 存在释放超时的问题
    public void limitFlow2(){
        Semaphore semaphore = new Semaphore(10);
        boolean acquire = false;
        try {
            acquire = semaphore.tryAcquire(1000, TimeUnit.MILLISECONDS);
            if(acquire){
                doSomething(Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if(acquire){
                semaphore.release();
            }
        }
    }

    // 真实用法

    public void doSomething(String param){
        System.out.println(param + "获取semaphore成功!");
    }

}
