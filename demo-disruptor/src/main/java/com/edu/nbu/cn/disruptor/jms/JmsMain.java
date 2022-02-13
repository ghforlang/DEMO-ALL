package com.edu.nbu.cn.disruptor.jms;

import com.edu.nbu.cn.disruptor.Product;
import com.edu.nbu.cn.disruptor.mutilconsumer.Producer;
import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import javafx.event.EventType;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author laoshi . hua
 * @version 1.0 2021/12/17-4:21 下午
 * @since 1.0
 */
public class JmsMain {


    // 定义ringBufferSize
    private static final int ringBufferSize = 1024 * 8;

    public static void main(String[] args) {
        // 线程池线程数
        int processors = Runtime.getRuntime().availableProcessors() * 2;
        // 创建消费者线程池
        ExecutorService consumerExecutor = Executors.newFixedThreadPool(processors);
        // 创建生产者线程池
        ExecutorService producerExecutor = Executors.newFixedThreadPool(1);

        //初始化distuptor
        Disruptor<Product> disruptor = new Disruptor<Product>(new EventFactory<Product>() {
            @Override
            public Product newInstance() {
                return new Product(EventType.ROOT);
            }
        },ringBufferSize,consumerExecutor, ProducerType.SINGLE,new BlockingWaitStrategy());

        //初始化handler
        StartHandler startHandler = new StartHandler();
        LeftHandler leftHandler = new LeftHandler();
        RightHandler rightHandler = new RightHandler();
        EndHandler endHandler = new EndHandler();

        disruptor.handleEventsWith(startHandler).then(leftHandler,rightHandler).then(endHandler);
        disruptor.start();

        Producer producer = new Producer(disruptor.getRingBuffer());
        producerExecutor.submit(producer);

        disruptor.shutdown();
    }
}
