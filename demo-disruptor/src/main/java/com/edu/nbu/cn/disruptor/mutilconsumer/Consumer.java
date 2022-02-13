package com.edu.nbu.cn.disruptor.mutilconsumer;

import com.edu.nbu.cn.disruptor.Product;
import com.lmax.disruptor.WorkHandler;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author laoshi . hua
 * @version 1.0 2021/12/17-3:07 下午
 * @since 1.0
 */
public class Consumer implements WorkHandler<Product> {

    private AtomicInteger id = new AtomicInteger(0);

    public Consumer() {
    }


    @Override
    public void onEvent(Product event) throws Exception {
        System.out.println(event.toString());
        id.incrementAndGet();
    }

    public int getCount(){
        return id.get();
    }
}
