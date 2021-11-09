package com.edu.nbu.cn.disruptor.offical.basic;

import com.lmax.disruptor.EventFactory;

/**
 * @author laoshi . hua
 * @version 1.0 2021/11/5-5:20 下午
 * @since 1.0
 * @description 事件工厂，用于空间预分配
 */
public class LongEventFactory implements EventFactory<LongEvent> {

    @Override
    public LongEvent newInstance() {
        return new LongEvent();
    }

    public static LongEventFactory INSTANCE(){
        return new LongEventFactory();
    }
}
