package com.edu.nbu.cn.designpattern.proxy.business;


import com.edu.nbu.cn.designpattern.proxy.Wine;

public class WineProxy implements SellWine {

    @Override
    public void sellWine(Wine wine) {
        System.out.println("购买" + wine.getName() + ",售价:" + wine.getPrice());
    }
}
