package com.edu.nbu.cn.designpattern.responsibilitychain.chain;

import com.edu.nbu.cn.designpattern.responsibilitychain.consumer.Consumer;

public interface FilterChain {

    boolean doFilter(Consumer consumer);
}
