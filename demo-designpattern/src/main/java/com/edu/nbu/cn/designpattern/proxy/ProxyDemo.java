package com.edu.nbu.cn.designpattern.proxy;

import com.edu.nbu.cn.designpattern.proxy.business.CosmeticsProxy;
import com.edu.nbu.cn.designpattern.proxy.business.SellWine;
import com.edu.nbu.cn.designpattern.proxy.factory.ProxyFactory;
import com.edu.nbu.cn.designpattern.proxy.business.SellCosmetics;
import com.edu.nbu.cn.designpattern.proxy.business.WineProxy;
import com.edu.nbu.cn.designpattern.proxy.cglib.CglibProxyFactory;

import java.lang.reflect.Proxy;

public class ProxyDemo {

    public static void main(String[] args) {

//       sellWine();
//       sellCosmetics();
       sellWineByCglib();
    }

    private static void sellWine(){
        WineProxy wineProxy = new WineProxy();
        ProxyFactory proxyFactory = new ProxyFactory(wineProxy);
        SellWine business = (SellWine)Proxy.newProxyInstance(wineProxy.getClass().getClassLoader(),wineProxy.getClass().getInterfaces(),proxyFactory);

        Wine wine = new Wine();
        wine.setName("红酒");
        wine.setPrice("$8888");
        business.sellWine(wine);
    }

    private static void sellCosmetics(){
        CosmeticsProxy cosmeticsProxy = new CosmeticsProxy();
        ProxyFactory proxyFactory = new ProxyFactory(cosmeticsProxy);
        SellCosmetics business = (SellCosmetics)Proxy.newProxyInstance(cosmeticsProxy.getClass().getClassLoader(),cosmeticsProxy.getClass().getInterfaces(),proxyFactory);

        Cosmetics cosmetics = new Cosmetics();
        cosmetics.setName("神仙水");
        cosmetics.setPrice("$200");
        business.sellCosmetics(cosmetics);
    }

    private static void sellWineByCglib(){
        CglibProxyFactory proxyFactory = new CglibProxyFactory();
        WineProxy wineProxy = (WineProxy) proxyFactory.getProxyInstance(new WineProxy());

        Wine wine = new Wine();
        wine.setName("红酒");
        wine.setPrice("$8888");
        wineProxy.sellWine(wine);
    }
}
