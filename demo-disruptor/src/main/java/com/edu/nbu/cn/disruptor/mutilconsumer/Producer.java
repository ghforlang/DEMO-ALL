package com.edu.nbu.cn.disruptor.mutilconsumer;

import com.edu.nbu.cn.disruptor.Product;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.Sequence;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author laoshi . hua
 * @version 1.0 2021/12/17-3:07 下午
 * @since 1.0
 */
public class Producer implements Runnable{
    private static final int MAX_NO = 1000;
    public static AtomicInteger idCount = new AtomicInteger(0);
    private RingBuffer<Product> buffer;

    public Producer(RingBuffer<Product> buffer) {
        this.buffer = buffer;
    }

    private void createData(){
        // 下一个可用slot
        long sequence = buffer.next();
        try{
            // 取出该slot中的事件
            Product product = buffer.get(sequence);
            // 初始化事件，通过事件传递业务数据
            int  id = idCount.incrementAndGet();
            product.setId(String.valueOf(id));
            product.setName("producer - " + id);
            product.setWeight(id);
        }finally {
            // 事件发布，确保事件一定会被发布;
            buffer.publish(sequence);
        }
    }


    @Override
    public void run() {
        // 单个消费者，最多生产数据1000个
        for(int i = 0;i < MAX_NO ;i++){
            createData();
        }
    }
}
