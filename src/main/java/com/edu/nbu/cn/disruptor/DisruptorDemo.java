package com.edu.nbu.cn.disruptor;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.BusySpinWaitStrategy;
import com.lmax.disruptor.LiteBlockingWaitStrategy;
import com.lmax.disruptor.LiteTimeoutBlockingWaitStrategy;
import com.lmax.disruptor.PhasedBackoffWaitStrategy;
import com.lmax.disruptor.SleepingWaitStrategy;
import com.lmax.disruptor.TimeoutBlockingWaitStrategy;
import com.lmax.disruptor.WaitStrategy;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class DisruptorDemo {
    public static StringEventFactory eventFactory = new StringEventFactory();
    private static final int bufferSize = 1024 * 1024;
    public static ExecutorService executor = Executors.newSingleThreadExecutor();
    private static ThreadFactory threadFactory = Executors.defaultThreadFactory();

    private static WaitStrategy yieldingWait = new YieldingWaitStrategy();
    private static WaitStrategy blockingWait = new BlockingWaitStrategy();
    private static WaitStrategy busySpinWait = new BusySpinWaitStrategy();
    private static WaitStrategy liteBlockingWait = new LiteBlockingWaitStrategy();
    private static WaitStrategy liteTimeoutBlockingWait = new LiteTimeoutBlockingWaitStrategy(100, TimeUnit.NANOSECONDS);
//    private static WaitStrategy phasedBackoffWait = new PhasedBackoffWaitStrategy();
    private static WaitStrategy sleepingWait = new SleepingWaitStrategy();
    private static WaitStrategy timeoutBlockingWait = new TimeoutBlockingWaitStrategy(100,TimeUnit.NANOSECONDS);

    Disruptor<StringEvent> disruptor = new Disruptor<StringEvent>(eventFactory,bufferSize,threadFactory,ProducerType.SINGLE,yieldingWait);

    public static void main(String[] args) {

    }
}
