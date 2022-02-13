package com.edu.nbu.cn.disruptor.mutilconsumer;

import com.edu.nbu.cn.disruptor.Product;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.IgnoreExceptionHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.Sequence;
import com.lmax.disruptor.WorkerPool;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.ProducerType;
import javafx.event.EventType;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author laoshi . hua
 * @version 1.0 2021/12/17-3:23 下午
 * @since 1.0
 */
public class MutilConsumerMain {

    // 定义ringBufferSize
    private static final int ringBufferSize = 1024 * 8;

    public static void main(String[] args) {
        // 线程池线程数
        int processors = Runtime.getRuntime().availableProcessors() * 2;
        // 创建消费者线程池
        ExecutorService consumerExecutor = Executors.newFixedThreadPool(processors);
        // 创建生产者线程池
        ExecutorService producerExecutor = Executors.newFixedThreadPool(processors);
        // 定义RingBuffer
        RingBuffer<Product> ringBuffer = RingBuffer.create(ProducerType.MULTI, new EventFactory<Product>() {
            @Override
            public Product newInstance() {
                return new Product(EventType.ROOT);
            }
        },ringBufferSize, new YieldingWaitStrategy());


        // 创建消费者池
        Consumer[] consumers = new Consumer[processors];
        for(int i=0 ; i<processors ; i++){
            consumers[i] = new Consumer();
        }

        WorkerPool<Product> workerPool = new WorkerPool(ringBuffer,ringBuffer.newBarrier(),new IgnoreExceptionHandler(),consumers);
        // 每个消费者，也就是workerProcessor都有一个sequence
        Sequence[] sequences = workerPool.getWorkerSequences();
        // 将其保存在ringBuffer中的sequence，为Producer申请slot时，sequence不能大于该数组中的最小值，防止被覆盖.
        ringBuffer.addGatingSequences(sequences);
        // 消费者线程,启动workerProcessor
        workerPool.start(consumerExecutor);

        // 生产者生产事件
        for(int i=0;i<processors ; i++){
            Producer producer = new Producer(ringBuffer);
            producerExecutor.submit(producer);
        }

        while(true){
            int count = 0;
            for(int i = 0;i < processors ;i ++){
                count += consumers[i].getCount();
            }

            System.out.println("生产者生产了 : " + Producer.idCount.get());
            System.out.println("消费者消费了 : " + count);

            try {
                TimeUnit.MILLISECONDS.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
