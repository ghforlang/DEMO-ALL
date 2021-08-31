package com.edu.nbu.cn;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class TestMapData {
    public static void main(String[] args) {
        TestMapData data = new TestMapData();
//        for(int i = 0;i<100 ;i ++){
//            System.out.println("第" + i + "次执行耗时:" + data.test());
//        }
        String jsonStr = "{\"detailFeeList\":[{\"amount\":\"1\",\"clinicLabel\":\"普通视力检查\",\"fee\":\"110.00000000000001\",\"itemCode\":\"DL0001\",\"itemDetail\":\"\",\"itemFeeDetail\":\"\",\"itemName\":\"普通视力检查J(甲)\",\"itemSpace\":\"/\",\"units\":\"次\"},{\"amount\":\"1\",\"clinicLabel\":\"综合验光仪验光\",\"fee\":\"1275\",\"itemCode\":\"DL0014\",\"itemDetail\":\"\",\"itemFeeDetail\":\"\",\"itemName\":\"综合验光仪验光Z\",\"itemSpace\":\"/\",\"units\":\"次\"},{\"amount\":\"1\",\"clinicLabel\":\"斜视度测定\",\"fee\":\"660\",\"itemCode\":\"DL0029\",\"itemDetail\":\"\",\"itemFeeDetail\":\"\",\"itemName\":\"斜视度测定J\",\"itemSpace\":\"/\",\"units\":\"次\"},{\"amount\":\"2\",\"clinicLabel\":\"裂隙灯检查\",\"fee\":\"330\",\"itemCode\":\"DL0074\",\"itemDetail\":\"\",\"itemFeeDetail\":\"\",\"itemName\":\"裂隙灯检查J(甲)\",\"itemSpace\":\"/\",\"units\":\"单眼\"},{\"amount\":\"2\",\"clinicLabel\":\"眼底检查\",\"fee\":\"550\",\"itemCode\":\"DL0088\",\"itemDetail\":\"\",\"itemFeeDetail\":\"\",\"itemName\":\"眼底检查J(甲)\",\"itemSpace\":\"不含散瞳\",\"units\":\"单眼\"},{\"amount\":\"1\",\"clinicLabel\":\"眼外肌功能检查\",\"fee\":\"660\",\"itemCode\":\"DL0101\",\"itemDetail\":\"\",\"itemFeeDetail\":\"\",\"itemName\":\"眼外肌功能检查J(甲)\",\"itemSpace\":\"/\",\"units\":\"次\"}],\"feeKind\":\"1\",\"feeName\":\"检查费\",\"totalFee\":\"4465\"}";
        FeeDTO feeDTO = JSON.parseObject(jsonStr,FeeDTO.class);
        feeDTO.setTime(new Date());
        feeDTO.setDetailFeeList(null);
        if(Objects.isNull(feeDTO)){
            System.out.println("obj is null!");
        }
        Map<String,Object> mapObj = (Map<String,Object>)JSON.parse(JSON.toJSONString(feeDTO));
        mapObj.forEach((k,v) -> {
            System.out.println("k : " + k + ", v :" + v);
        });
    }

    public long test(){
        List<String> strList = buildStrList();
        Map<String,Long> strMap = buildStrMap();
        long startTime = System.currentTimeMillis();
        strList = strList.stream().filter(str -> Objects.nonNull(strMap.get(str))).collect(Collectors.toList());
        long endTime = System.currentTimeMillis();
        strList.forEach(str -> System.out.println(str));
        return endTime - startTime;
    }


    public static List<String> buildStrList(){
        List<String> randomStr = new ArrayList<>(10000);
        Random random = new Random();
        for(int i=0;i<10000; i++){
            randomStr.add(String.valueOf(random.nextLong()));
        }
        return randomStr;
    }


    public static Map<String,Long> buildStrMap(){
        Map<String,Long> strMap = new HashMap<>(50000);
        Random random = new Random();
        for(int i=0;i<50000;i++){
            strMap.put(String.valueOf(random.nextLong()),random.nextLong());
        }
        return strMap;
    }
}
