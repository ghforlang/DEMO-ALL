package com.edu.nbu.cn.demo.properties;

import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;

/**
 *
 * @version 1.0
 * @Date 2021/6/2 8:37 下午
 * @since 1.0
 */
public class PropertiesTest {
    public static void main(String[] args) {
        // 系统环境变量
        Map<String,String> envProperties = System.getenv();
        System.out.println("env.size = " + envProperties.size());
        envProperties.forEach((k,v) ->{
            System.out.println(k + " : " + v);
        });

        // 系统属性 -D参数
        Properties sysProperties = System.getProperties();
        sysProperties.setProperty("哈哈哈","hahaha");
        System.out.println("sys.size = " + sysProperties.entrySet().size());
        sysProperties.forEach((k,v) ->{
            System.out.println(k + " : " + v);
        });

//        System.out.println(sysProperties);
//        System.out.println("className : " + PropertiesTest.class.getName());
//        System.out.println("simpleClassName : " + PropertiesTest.class.getSimpleName());
    }
}
