package com.edu.nbu.cn.bytebuddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.NamingStrategy;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author laoshi . hua
 * @version 1.0 2023/7/27-3:35 PM
 * @since 1.0
 */
public class NamingStrategyDemo {
    public static void main(String[] args) {
        testNamingStrategyCustom();
        testNamingStrategySuffixingRandom();
    }

    private static void testNamingStrategySuffixingRandom() {
        ByteBuddy buddy = new ByteBuddy();
        buddy.with(new NamingStrategy.SuffixingRandom("suffix"));
        DynamicType.Unloaded<?> unloaded = buddy.subclass(Object.class)
                .make();
        Class clazz = unloaded.load(NamingStrategyDemo.class.getClassLoader()).getLoaded();
        System.out.println(clazz.getName());
    }

    public static void testNamingStrategyCustom(){
        AtomicLong ad = new AtomicLong(11234123L);
        DynamicType.Unloaded<?> unloaded = new ByteBuddy()
                .with(new NamingStrategy.AbstractBase(){
                    @Override
                    protected String name(TypeDescription superClass) {
                        return "xxx.xxx.xxx.xxx" +  ad.longValue();
                    }
                })
                .subclass(Object.class)
                .make();
        Class clazz = unloaded.load(NamingStrategyDemo.class.getClassLoader()).getLoaded();
        System.out.println(clazz.getName());
    }
}
