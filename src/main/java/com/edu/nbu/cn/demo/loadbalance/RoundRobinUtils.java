package com.edu.nbu.cn.demo.loadbalance;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 参考dubbo 负载均衡策略、拓展
 * dubbo负载均衡策略有 随机负载均衡、最近最不活跃负载均衡（leastActiveLoadbalance）、一致性hash（ConsistentHash）、加权轮询(RoundRobin)
 * dubbo中的加权轮询参考的是nginx的平滑加权轮询算法
 * 下面是对应的demo
 */
public class RoundRobinUtils {


    public static List<String> smoothRoundRobin(Map<String,Integer> candidateMap,int requestCount){
        Map<String,Integer> currentRoundMap = new ConcurrentHashMap<>(candidateMap);
        Integer sumWeight = candidateMap.values().stream().mapToInt(value -> value).sum();

        List<String> resultList = new ArrayList<>();
        for(int i=0 ; i<requestCount ; i++){
            //寻找当前权重最大的节点
            String currentMaxWeight = currentMaxWeight(currentRoundMap);
            //选中
            resultList.add(currentMaxWeight);
            //选中节点权重 - 总权重，然后重置该节点权重
            currentRoundMap.put(currentMaxWeight,currentRoundMap.get(currentMaxWeight) - sumWeight);
            //当前每个节点权重 + 初始每个节点权重
            reRoundMapValue(currentRoundMap,candidateMap);
        }
        return resultList;
    }

    public static String currentMaxWeight(Map<String,Integer> currentRoundMap){
        List<Integer> valueList = new ArrayList<>(currentRoundMap.values());
        int maxWeight = 0;
        for(int weight : valueList){
            if(weight >=maxWeight){
                maxWeight = weight;
            }
        }

        for(Map.Entry<String,Integer> entry : currentRoundMap.entrySet()){
            if(entry.getValue() == maxWeight){
                return entry.getKey();
            }
        }
        return "";
    }

    private static void reRoundMapValue(Map<String,Integer> currentMap,Map<String,Integer> initialMap){
        currentMap.forEach((current,currentWeight) ->{
            currentWeight += initialMap.get(current);
            currentMap.put(current,currentWeight);
        });
    }

}
