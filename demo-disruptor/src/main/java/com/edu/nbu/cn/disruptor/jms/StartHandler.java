package com.edu.nbu.cn.disruptor.jms;

import com.edu.nbu.cn.disruptor.Product;
import com.lmax.disruptor.EventHandler;

/**
 * @author laoshi . hua
 * @version 1.0 2021/12/17-4:09 下午
 * @since 1.0
 */
public class StartHandler implements EventHandler<Product> {

    @Override
    public void onEvent(Product event, long sequence, boolean endOfBatch) throws Exception {
        System.out.println("start handling !");
        event.setName("start node");
    }
}
