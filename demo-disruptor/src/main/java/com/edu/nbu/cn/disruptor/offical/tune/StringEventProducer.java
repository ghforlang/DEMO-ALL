package com.edu.nbu.cn.disruptor.offical.tune;

import com.edu.nbu.cn.disruptor.offical.basic.LongEvent;
import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

/**
 * @author laoshi . hua
 * @version 1.0 2021/11/8-3:26 下午
 * @since 1.0
 */
public class StringEventProducer {
    private final RingBuffer<ObjectEvent<String>> ringBuffer;


    public StringEventProducer(RingBuffer<ObjectEvent<String>> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    private static final EventTranslatorOneArg<ObjectEvent<String>, ByteBuffer> TRANSLATOR =
            new EventTranslatorOneArg<ObjectEvent<String>, ByteBuffer>() {
                @Override
                public void translateTo(ObjectEvent<String> event, long sequence, ByteBuffer arg0) {
                    event.set(sequence + "");
                }
            };
    public  void onData(ByteBuffer bb){
        ringBuffer.publishEvent(TRANSLATOR,bb);
    }
}
