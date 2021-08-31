package com.edu.nbu.cn.stream.map;

import com.edu.nbu.cn.stream.Person;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import static com.edu.nbu.cn.stream.constant.Constants.*;

/**
 *
 * @version 1.0
 * @Date 2021/3/24 11:27 上午
 * @since 1.0
 */
public class MapDemo {
    public static void main(String[] args) {

        //getOrDefault
        System.out.println(COMMON_MAP.get("c"));
        System.out.println(COMMON_MAP.getOrDefault("d",5));

        // putIfAbsent
        System.out.println(COMMON_MAP.get("d"));
        System.out.println(COMMON_MAP.putIfAbsent("d",5));
        System.out.println(COMMON_MAP.get("d"));

        // remove(k,v)
        COMMON_MAP.remove("d",4);
        printMap(COMMON_MAP);

        //remove(k)
        COMMON_MAP.remove("d");
        printMap(COMMON_MAP);

        //replace(k,v),replace(k,v,newv)
        System.out.println(COMMON_MAP.putIfAbsent("d",5));
        COMMON_MAP.replace("d",4);
        printMap(COMMON_MAP);
        COMMON_MAP.replace("d",4,5);
        printMap(COMMON_MAP);

        //replaceAll
        COMMON_MAP.replaceAll((k,v) ->
            v = v + 1);
        printMap(COMMON_MAP);

        //merge,k对应的原value值为null，则直接将value值置为传的value，否则直接替换原value值；
        COMMON_MAP.merge("e",10,(k,v) -> v + 1);
        printMap(COMMON_MAP);
        COMMON_MAP.merge("e",10,(k,v) -> v + 1);
        printMap(COMMON_MAP);

        //compute,类似merge，oldValue == null && newValue == null,则直接返回null；
        // oldValue != null && newValue = null 直接remove oldValue;
        COMMON_MAP.compute("e",(k,v) -> v++);
        printMap(COMMON_MAP);

        //computeIfAbsent
        COMMON_MAP.computeIfAbsent("f",k -> k.hashCode());
        printMap(COMMON_MAP);

        //computeIfPresentz
        COMMON_MAP.computeIfPresent("e",(k,v) -> k.hashCode());
        COMMON_MAP.computeIfPresent("g",(k,v) -> v.hashCode());
        printMap(COMMON_MAP);

        //按照模2分组A
        ConcurrentMap<Integer,List<Integer>> integerListConcurrentMap = COMMON_INT_LIST.parallelStream().collect(Collectors.groupingByConcurrent(v -> v %2));
        printMap(integerListConcurrentMap);
       //按照性别分组
        ConcurrentMap<Integer,List<Person>> currentMap =  COMMON_PERSON_LIST.parallelStream().collect(Collectors.groupingByConcurrent(Person::getGender));
        printMap(currentMap);
    }

    private static void printMap(Map map){
        map.forEach((k,v) ->{
            System.out.println("[" + k + "," + v + "]");
        });
    }
}
