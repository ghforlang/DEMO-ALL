package com.edu.nbu.cn.demo.hongbao;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@UtilityClass
public class RandomHongBaoUtils {

    public static List<Long> splitHongbao(long totalValue,int count){
        if(totalValue <= 0 || count <=0){
            throw new RuntimeException("无效金额、红包个数！");
        }

        List<Long> hongbaoList = new ArrayList<>(count);
        if(count == 1){
            hongbaoList.add(totalValue);
            return hongbaoList;
        }

        long remainedValue = totalValue;
        Random random = new Random();
        for(int i = 0; i < count - 1 ; i ++){
            // nextDouble 取值范围 0<= x < 1
            double percent = random.nextDouble();
            if(percent == 0.0){
                //无效值，重新循环
                continue;
            }
            long subValue = Math.round(totalValue * percent);
            if(subValue == 0 || subValue >= remainedValue ){
                //无效值，重新循环
                continue;
            }
            remainedValue = remainedValue - subValue;
            hongbaoList.add(subValue);
        }
        hongbaoList.add(remainedValue);
        return hongbaoList;
    }






}
