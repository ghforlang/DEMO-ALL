package com.edu.nbu.cn.data.cleanout.utils;


import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author laoshi . hua
 * @version 1.0 2022/1/8-4:31 下午
 * @since 1.0
 */
public class StreamUtils {
    /**
     * list转换
     * @param srcList
     * @param mapper
     * @param <R>
     * @param <T>
     * @return
     */
    public static <R,T> List<T> toList(List<R> srcList, Function<R,T> mapper){
        return CollectionUtils.isEmpty(srcList) ? Collections.EMPTY_LIST : srcList.stream().map(mapper).collect(Collectors.toList());
    }

    /**
     * list过滤
     * @param list
     * @param predicates
     * @param <T>
     * @return
     */
    public static <T> List<T> listFilter(List<T> list, Predicate<T>... predicates){
        if(CollectionUtils.isEmpty(list)){
            return Collections.EMPTY_LIST;
        }
        for (Predicate<T> p : predicates){
            list = list.stream().filter(p).collect(Collectors.toList());
        }
        return list;
    }

    /**
     * 简单的List转Map（聚合）
     *
     * @param list
     * @param classifier
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T, R> Map<R, List<T>> toGroupMap(List<T> list, Function<T, R> classifier) {
        return CollectionUtils.isEmpty(list) ? Collections.EMPTY_MAP : list.stream().collect(Collectors.groupingBy(classifier));
    }

    /**
     * list转map，key合并
     * @param list
     * @param key
     * @param value
     * @param <T>
     * @param <K>
     * @param <V>
     * @return
     */
    public static <T, K, V> Map<K, V> toMap(List<T> list, Function<T, K> key, Function<T, V> value) {
        return org.apache.commons.collections.CollectionUtils.isEmpty(list) ? Collections.EMPTY_MAP : (Map)list.stream().collect(Collectors.toMap(key, value, (key1, key2) -> {
            return key2;
        }));
    }

    /**
     * 简单map抓换
     * @param sourceMap
     * @param resultMap
     * @param keyMapper
     * @param valueMapper
     * @param <KR>
     * @param <KT>
     * @param <R>
     * @param <T>
     * @return
     */
    public static <KR,KT,R,T> Map<KT,T> simpleMapTransform(Map<KR, R> sourceMap, Map<KT,T> resultMap, Function<KR,KT> keyMapper, Function<R,T> valueMapper){
        if(MapUtils.isEmpty(sourceMap)){
            return Collections.EMPTY_MAP;
        }

        sourceMap.forEach((k,v) ->{
            resultMap.putIfAbsent(keyMapper.apply(k),valueMapper.apply(v));
        });
        return resultMap;
    }

    /**
     * 组合map转换
     * @param sourceMap
     * @param resultMap
     * @param keyMapper
     * @param valueMapper
     * @param <KR>
     * @param <KT>
     * @param <R>
     * @param <T>
     * @return
     */
    public static <KR,KT,R,T> Map<KT, List<T>> mapTransform(Map<KR, List<R>> sourceMap, Map<KT,List<T>> resultMap, Function<KR,KT> keyMapper, Function<R,T> valueMapper){
        if(MapUtils.isEmpty(sourceMap)){
            return Collections.EMPTY_MAP;
        }

//        sourceMap.forEach((k,v) ->{
//            if(v instanceof Map){
//                log.warn("not support now!");
//            }else if(v instanceof List){
//                resultMap.putIfAbsent(keyMapper.apply(k), toList( v, valueMapper));
//            }else if(v instanceof Set){
//                log.warn("not support now!");
//            }else{
//                log.warn("not support now!");
//            }
//        });
        return resultMap;
    }

    /**
     * 数组转list
     * @param arrays
     * @param mapper
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T, R> List<R> arrayTrans(T[] arrays, Function<T, R> mapper) {
        return !Objects.isNull(arrays) && arrays.length > 0 ?  Arrays.asList(arrays).stream().map(mapper).collect(Collectors.toList()) : Collections.EMPTY_LIST;
    }
}
