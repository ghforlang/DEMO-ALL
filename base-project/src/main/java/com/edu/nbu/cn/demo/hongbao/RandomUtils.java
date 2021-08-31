package com.edu.nbu.cn.demo.hongbao;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomUtils {

    public static final double TOTAL = 1.0f;

    //递归拆分 1.0
    public static List<Double> split(int count){
        if(count <= 0){
            throw  new RuntimeException("无效参数！");
        }
        Random random = new Random();
        List<Double> splitResult = new ArrayList<>();
        double remained = TOTAL;
        for(int i = 0;i < count - 1; i++ ){
            double subValue = random.nextDouble();
            if(subValue == 0.0 || subValue >remained){
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

    public static void main(String[] args) {
        List<Double> result = split(10);
        double totalValue = result.stream().mapToDouble(value -> value).sum();
        System.out.println(Thread.currentThread().getName() + " - " + totalValue + " -> " + result);
    }

}
