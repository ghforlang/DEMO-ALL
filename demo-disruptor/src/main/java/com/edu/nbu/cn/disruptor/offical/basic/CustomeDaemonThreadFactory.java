package com.edu.nbu.cn.disruptor.offical.basic;

import java.util.concurrent.ThreadFactory;

/**
 * @author laoshi . hua
 * @version 1.0 2021/11/5-5:41 下午
 * @since 1.0
 */
public class CustomeDaemonThreadFactory implements ThreadFactory {
    @Override
    public  Thread newThread(Runnable r) {
        return new LongEventThread("longEvent-DeamonThread");
    }

    public static CustomeDaemonThreadFactory INSTANCE(){
        return new CustomeDaemonThreadFactory();
    }
}
