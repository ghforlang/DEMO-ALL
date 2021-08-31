package com.edu.nbu.cn.designpattern.responsibilitychain;

import com.edu.nbu.cn.designpattern.responsibilitychain.consumer.Consumer;
import com.edu.nbu.cn.designpattern.responsibilitychain.chain.FilterChain;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 作为使用者，无需关心filter内部实现，只管装配
 */
public class ResponsibilityChain {

    private static final List<FilterChain> filterChainList = new CopyOnWriteArrayList<>();

//    static {
//        filterChainList.add(new SpecialConsumerFilterChain());
//        filterChainList.add(new DayConsumerTimesFilterChain());
//        filterChainList.add(new MouslimConsumerFilterChain());
//    }


    public  List<FilterChain> getFilterChainList(){
        return filterChainList;
    }

    public void addFilter(FilterChain filterChain){
        filterChainList.add(filterChain);
    }


    public void doFilter(Consumer consumer){
        filterChainList.forEach(chain -> chain.doFilter(consumer));
    }

}
