package com.edu.nbu.cn.disruptor.offical.tune;

import com.edu.nbu.cn.disruptor.offical.basic.LongEvent;
import com.edu.nbu.cn.disruptor.offical.basic.LongEventFactory;
import com.edu.nbu.cn.disruptor.offical.basic.LongEventProducer;
import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.lmax.disruptor.util.DaemonThreadFactory;
import lombok.SneakyThrows;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

/**
 * @author laoshi . hua
 * @version 1.0 2021/11/8-2:35 下午
 * @since 1.0
 * @Description 基本调优选项
 */
public class BasicTuningOptions {
    // 调优选项均在构建Disruptor时指定

    @SneakyThrows
    public static void main(String[] args) {
        EventFactory<LongEvent> longEventEventFactory = new LongEventFactory();
        int bufferSize = 1024;

        // 使用ProducerType.SINGLE创建SingleProducerSequencer
        Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>(longEventEventFactory,
                bufferSize,
                DaemonThreadFactory.INSTANCE,
                ProducerType.SINGLE,
                new BlockingWaitStrategy());
        /** 等待策略，WaitStrategy
         *    BlockingWaitStrategy,默认策略，内部采用Lock的Condition实现
         *    SleepingWaitStrategy ,内部采用LockSupport.park实现;在无需低延迟、对生产线程影响较小的情况下非常适用，常用场景比如异步日志。
         *    YieldingWaitStrategy，内部采用自旋 + Thread.yield的方式，同样适用于低延迟系统；如果系统需要非常高的性能，当前消费者(EventHandler)数量小于当前系统的逻辑核心数(也就是说允许超程),推荐该策略。
         *   BusySpinWaitStrategy，性能最好的等待策略。与YieldingWaitStrategy类似，适用于低延迟系统，但是对系统参数有严格限制，比如，只适用于当前消费者(EventHandler)数量小于当前系统的物理核心数(也就是说不允许超程)。
         */

        /**
         * clear RingBuffer
         */
        Disruptor<ObjectEvent<String>> stringDisruptor = new Disruptor<ObjectEvent<String>>(() -> new ObjectEvent<String>(),1024,DaemonThreadFactory.INSTANCE);
        stringDisruptor.handleEventsWith((event,sequence,endOfBatch) ->{
            System.out.println(event.get());
        }).then(new ObjectEventHandler());
        stringDisruptor.start();

        RingBuffer<ObjectEvent<String>> ringBuffer = stringDisruptor.getRingBuffer();
        StringEventProducer StringProducer = new StringEventProducer(ringBuffer);
        ByteBuffer bb = ByteBuffer.allocate(8);
        for (long l=0;true ;l++){
            bb.putLong(0,l);
            StringProducer.onData(bb);
//            ringBuffer.publishEvent(((event, sequence, buffer) -> event.setData(buffer.getLong(0))),bb);
            TimeUnit.MILLISECONDS.sleep(1000L);
        }
    }
}
