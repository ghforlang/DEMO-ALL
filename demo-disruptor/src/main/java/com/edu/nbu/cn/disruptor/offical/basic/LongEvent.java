package com.edu.nbu.cn.disruptor.offical.basic;

/**
 * @author laoshi . hua
 * @version 1.0 2021/11/5-5:19 下午
 * @since 1.0
 * @description 事件定义
 */
public class LongEvent {
    public void setData(Long data) {
        this.data = data;
    }

    private Long data;
}
