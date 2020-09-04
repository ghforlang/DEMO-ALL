package com.edu.nbu.cn.proxy;

import com.edu.nbu.cn.proxy.business.CosmeticsProxy;
import com.edu.nbu.cn.proxy.business.SellCosmetics;
import com.edu.nbu.cn.proxy.business.SellWine;
import com.edu.nbu.cn.proxy.business.WineProxy;
import com.edu.nbu.cn.proxy.cglib.CglibProxyFactory;
import com.edu.nbu.cn.proxy.factory.ProxyFactory;

import java.lang.reflect.Proxy;

public class ProxyDemo {

    public static void main(String[] args) {

//       sellWine();
//       sellCosmetics();
       sellWineByCglib();
//        business.sell(cosmetics);
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
