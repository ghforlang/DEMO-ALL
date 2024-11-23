package com.edu.nbu.cn.alltest;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author laoshi . hua
 * @version 1.0 2024/7/18-13:58
 * @since 1.0
 */
public class Test {
    public static void main(String[] args) {
//        BigDecimal bd = new BigDecimal("170.0");
//        DecimalFormat df = new DecimalFormat("#.0");
//        String formatted = df.format(bd);
//        System.out.println(formatted); // 输出 "170.0"
//        System.out.println(bd.setScale(2,BigDecimal.ROUND_HALF_UP));


//        testParamilizedMap();
        testSplit();
    }

    public static void testParamilizedMap(){
        Map<String, List<Object>> objectMap = new HashMap<>();
        objectMap.put("a", Arrays.asList(1,2));
        objectMap.put("b", Arrays.asList("hello","hh"));
        objectMap.put("c", Arrays.asList(1.0,2.0));

        objectMap.forEach((k,v) ->{
            System.out.println(k);
            v.forEach(o ->{
                System.out.println(o.getClass());
            });
        });
    }

    public static void testSplit(){
        String str = "00:00:14.900";
        System.out.println(str.split(":")[2].split("[.]")[0]);
    }
}
