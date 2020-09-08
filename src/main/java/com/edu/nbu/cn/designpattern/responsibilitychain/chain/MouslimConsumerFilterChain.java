package com.edu.nbu.cn.designpattern.responsibilitychain.chain;

import com.edu.nbu.cn.designpattern.responsibilitychain.consumer.Consumer;

public class MouslimConsumerFilterChain implements FilterChain {

    @Override
    public boolean doFilter(Consumer consumer) {
        System.out.println(consumer.getName() + " 是否可以在此消费? " + (consumer.isMouslim() ? " 可以" : "不可以") );
        return consumer.isMouslim() && consumer.canConsume();
    }
}
