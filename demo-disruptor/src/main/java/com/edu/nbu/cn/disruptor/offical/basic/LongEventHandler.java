package com.edu.nbu.cn.disruptor.offical.basic;

import com.lmax.disruptor.EventHandler;

/**
 * @author laoshi . hua
 * @version 1.0 2021/11/5-5:22 下午
 * @since 1.0
 * @description disruptor的消费者，
 */
public class LongEventHandler implements EventHandler<LongEvent> {
    @Override
    public void onEvent(LongEvent longEvent, long sequence, boolean endOfBatch) throws Exception {
        System.out.println(longEvent.getClass() + ",value=" + sequence + " , b=" + endOfBatch);
    }
}
