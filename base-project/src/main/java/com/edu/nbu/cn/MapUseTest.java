package com.edu.nbu.cn;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @version 1.0
 * @Date 2021/5/24 7:41 下午
 * @since 1.0
 */
public class MapUseTest {

    public static void main(String[] args) {
        Map<String,String> sumMap = new HashMap<>();
        sumMap.put("a","aa");
        sumMap.put("b","bb");

        Map<String,String> subMap = new HashMap<>();
        subMap.putAll(subMap);
        subMap.put("sub","sub");

        sumMap.forEach((k,v) ->{
            System.out.println(k + "," + v);
        });
    }

}
