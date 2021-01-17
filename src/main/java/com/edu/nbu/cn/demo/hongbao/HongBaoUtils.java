package com.edu.nbu.cn.demo.hongbao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 红包工具探究
 * 这里提到两个比较有意思的类Random 与ThreadlocalRandom
 *
 */
public class HongBaoUtils {

    private static final Double TOTAL = 1D;

    public static List<Double> split(int count){
        if(count <= 0){
            throw new RuntimeException("无效参数！");
        }

        Random random = new Random();
        List<Double> splitResult = new ArrayList<>();
        double remained = TOTAL;
        for(int i=0;i<count -1;i++){
            double subValue = random.nextDouble();
            if(subValue == 0 || subValue > remained){
                continue;
            }
            remained = remained - subValue;
            if(remained <= 0){
                continue;
            }
            splitResult.add(subValue);
        }
        splitResult.add(remained);
        return splitResult;
    }
}
