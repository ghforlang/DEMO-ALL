package com.edu.nbu.cn.designpattern.proxy.business;


import com.edu.nbu.cn.designpattern.proxy.Cosmetics;

public class CosmeticsProxy implements SellCosmetics{

    @Override
    public void sellCosmetics(Cosmetics cosmetics) {
        System.out.println("购买" + cosmetics.getName() + ",售价:" + cosmetics.getPrice());
    }
}

