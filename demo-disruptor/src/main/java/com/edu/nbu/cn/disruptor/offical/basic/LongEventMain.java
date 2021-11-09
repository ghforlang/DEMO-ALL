package com.edu.nbu.cn.disruptor.offical.basic;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.util.DaemonThreadFactory;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

/**
 * @author laoshi . hua
 * @version 1.0 2021/11/5-5:25 下午
 * @since 1.0
 */
public class LongEventMain {
    public static void main(String[] args) throws InterruptedException {

        int bufferSize = 1024;
        Disruptor<LongEvent> disruptor = new Disruptor<>(LongEvent::new,bufferSize, DaemonThreadFactory.INSTANCE);
//        disruptor.handleEventsWith(((event, sequence, endOfBatch) -> System.out.println("Event= " + event)));
        disruptor.handleEventsWith(new LongEventHandler());
        disruptor.start();

        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
        LongEventProducer producer = new LongEventProducer(ringBuffer);
        ByteBuffer bb = ByteBuffer.allocate(8);
        for (long l=0;true ;l++){
            bb.putLong(0,l);
            producer.onData(bb);
//            ringBuffer.publishEvent(((event, sequence, buffer) -> event.setData(buffer.getLong(0))),bb);
            TimeUnit.MILLISECONDS.sleep(1000L);
        }
    }
}
