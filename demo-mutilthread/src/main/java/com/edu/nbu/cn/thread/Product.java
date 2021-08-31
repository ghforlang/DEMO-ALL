package com.edu.nbu.cn.thread;

/**
 *
 * @version 1.0
 * @Date 2021/5/13 3:47 下午
 * @since 1.0
 */
public class Product {

    private volatile long count;

    public long getCount(){
        return count;
    }

    public void setCount(long count){
        this.count = count;
    }

}
