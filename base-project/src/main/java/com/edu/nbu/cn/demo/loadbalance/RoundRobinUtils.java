package com.edu.nbu.cn.demo.loadbalance;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * 参考dubbo负载均衡策略，拓展，dubob的负载均衡算法有，随机负载均衡（RandomLoadBalance）、最近最不活跃负载均衡算法（LeastActiveLoadBalance）、
 * 一致性hash负载均衡算法（ConsistentHashLoadBalance）还有加权轮询负载均衡算法（RoundRobinLoadBalance）
 * dubbo负载均衡策略中的RoundRobin参考的是nginx的平滑加权轮询算法
 *
 */
public class RoundRobinUtils {

    public static final Map<String,Integer> MAP = new HashMap<>();

    static{
        MAP.put("A",5);
        MAP.put("B",1);
        MAP.put("C",1);
    }

    public static void main(String[] args) {
        List<String> roundRobinResult = smoothRoundRobin(MAP,7);
        System.out.println(StringUtils.join(roundRobinResult,"->"));
    }

    /**
     * 平滑加权轮询算法工具,相对于普通的加权轮询算法，防止区域内流量全部打在一个节点
     * @param candidateMap 候选map<候选人，权重></>
     * @return
     */
    public static List<String> smoothRoundRobin(Map<String,Integer> candidateMap,int requestCount){
        Map<String,Integer> currentRoundMap = new HashMap<>(candidateMap);
        Integer sumWeight = candidateMap.entrySet().stream().mapToInt(value -> value.getValue()).sum();

        List<String> resultList = new ArrayList<>();

        for(int i=0;i<requestCount;i++){
            //当前权重最大的节点key,例如，初始是5
            String currentMaxWeight = currentMaxWeight(currentRoundMap);
            //选中，放入结果
            resultList.add(currentMaxWeight);
            //更新当前权重最大节点的权重；当前权重最大节点权重- 总权重
            currentRoundMap.put(currentMaxWeight,currentRoundMap.get(currentMaxWeight) - sumWeight);
            //权重重新分配；当前每个节点权重 + 初始每个节点权重
            reRoundMapValue(currentRoundMap,MAP);
        }
        return resultList;
    }

    private static String currentMaxWeight(Map<String,Integer> candidateMap){
        List<Integer> weightList = new ArrayList<>(candidateMap.values());

        weightList.sort(Integer::compareTo);
        int maxWeight = weightList.get(weightList.size() - 1);
        for(Map.Entry<String,Integer> entry : candidateMap.entrySet()){
            if(entry.getValue() == maxWeight){
                return entry.getKey();
            }
        }
        return "";
    }

    private static void reRoundMapValue(Map<String,Integer> roundMap,Map<String,Integer> initialCandidateMap){
        roundMap.forEach((candidate,currentWeight) ->{
            currentWeight += initialCandidateMap.get(candidate);
            roundMap.put(candidate,currentWeight);
        });
    }
}
