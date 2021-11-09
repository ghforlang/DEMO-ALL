package com.edu.nbu.cn.disruptor.offical.tune;

import com.lmax.disruptor.EventHandler;

/**
 * @author laoshi . hua
 * @version 1.0 2021/11/8-3:16 下午
 * @since 1.0
 */
public class ObjectEventHandler<T> implements EventHandler<ObjectEvent<T>> {

    @Override
    public void onEvent(ObjectEvent<T> event, long sequence, boolean endOfBatch) throws Exception {
        event.clear();
        System.out.println("after clear -> data: " + event.get());
    }
}
