package com.edu.nbu.cn.stream;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.edu.nbu.cn.stream.constant.Constants.*;

/**
 *
 * @version 1.0
 * @Date 2021/3/24 2:29 下午
 * @since 1.0
 */
public class StreamDemo {

    private static final Stream<String> stream = Arrays.stream(new String[]{"x","y"});
    //Stream api结构： 顶级接口，BaseStream
    // 3个子类 DoubleStream,LongStream,IntStream
    // 特点： 无存储（类似视图）、操作不会影响原数据源、惰性执行（只有在真正需要结果的以后才执行到）、一次性（用过之后不可再用）
    // 操作分类，
    //  中间型：concat() distinct() filter() flatMap() limit() map() peek()
    //  skip() sorted() parallel() sequential() unordered()
    //  操作型：allMatch() anyMatch() collect() count() findAny() findFirst()
    //  forEach() forEachOrdered() max() min() noneMatch() reduce() toArray()
    // 核心方法：
    public static void main(String[] args) {

        //中间型

        //concat ,流拼接
        Stream<String> concatedStream = Stream.concat(COMMON_STREAM,stream);
        concatedStream.forEach(v -> System.out.println(v));

        //filter
        resetStream();
        Stream<String> streamx = COMMON_STREAM.filter(v -> v.equals("a"));
        resetStream();
        COMMON_STREAM.forEach(v -> System.out.print(v));
        System.out.println();
        streamx.forEach(v -> System.out.print(v));
        System.out.println();

        //distinct
        System.out.println(StringUtils.join(COMMON_STR_LIST,","));
        COMMON_STR_LIST.add("a");
        System.out.println(StringUtils.join(COMMON_STR_LIST,","));
        COMMON_STR_LIST.stream().distinct().forEach(v -> System.out.println(v));


        //map
        resetStream();
        COMMON_STREAM.map(v -> v.toUpperCase()).forEach(v -> System.out.println(v));

        //flatMap,把stream的元素打平
        Stream<List<Integer>> stream2 = Stream.of(Arrays.asList(1,2),Arrays.asList(3,4,5));
        stream2.flatMap(list -> list.stream()).forEach(v -> System.out.println(v));

        //limit,限制流长度，不超过size
        resetStream();
        COMMON_STREAM.limit(2).forEach(v -> System.out.println(v));

        //peek
        resetStream();
        COMMON_STREAM.map(v -> v.toUpperCase()).peek(v -> System.out.println("after map : " + v)).forEach(v -> System.out.println(v));
        resetStream();
        COMMON_STREAM.peek(v -> System.out.println("after peek : " + v));

        //skip,跳过n个
        System.out.println(StringUtils.join(COMMON_STR_LIST,","));
        resetStream();
        COMMON_STREAM.skip(1).forEach(v -> System.out.println(v));

        //sorted
        resetStream();
        COMMON_STREAM.sorted().forEach(v -> System.out.println(v));
        resetStream();
        COMMON_STREAM.sorted((v1,v2) -> v2.hashCode() - v1.hashCode()).forEach(v -> System.out.println(v));

        //parallel，用于非parallel 转parallel
        resetStream();
        COMMON_STREAM.parallel().forEach(v -> System.out.println(v));

        //sequential,用于非sequential转sequential
        resetStream();
        COMMON_STREAM.sequential().forEach(v -> System.out.println(v));

        //unordered,乱序
        resetStream();
        COMMON_STREAM.unordered().forEach(v -> System.out.println(v));

//        ---------------------------------操作型-------------------------------------------
//        allMatch() anyMatch() collect() count() findAny() findFirst()
//        forEach() forEachOrdered() max() min() noneMatch() reduce() toArray()

        //toArray
        resetStream();
        String[] strArray = COMMON_STREAM.toArray(String[]::new);
        System.out.println("strArray : " + StringUtils.join(strArray,","));

        // reduce 对parallel stream 是线程安全操作
        resetStream();
        //一个参数
        Optional<String> maxLengthStr = COMMON_STREAM.reduce((v1,v2) -> v1.length() >= v2.length() ? v1 : v2);
        System.out.println("maxLengthStr : " + maxLengthStr.get());
        resetStream();
        //两个参数
        String reduceResult = COMMON_STREAM.reduce("",(v1,v2) -> v1 + v2);
        System.out.println("reduceResult : " + reduceResult);
        resetStream();
        //三个参数
        String reduceResult1 = COMMON_STREAM.reduce("",(v1,v2) -> v1 + v2,Objects::toString);
        System.out.println("reduceResult1 : " + reduceResult1);
        int sumResult = COMMON_INT_LIST.stream().reduce(0,(v1,v2) -> v1 + v2,Integer::sum);
        System.out.println("sumResult : " + sumResult);

        //collect 对parallel stream 是线程安全操作
        resetStream();
        Set<String> set = COMMON_STREAM.collect(Collectors.toSet());
        System.out.println("set : " + StringUtils.join(set,","));
        resetStream();
        List<String> list = COMMON_STREAM.collect(Collectors.toList());
        System.out.println("list : " + StringUtils.join(list,","));
        resetStream();
        System.out.println("join : " + COMMON_STREAM.collect(Collectors.joining(",")));
        resetStream();
        System.out.println("prefix : " + COMMON_STREAM.collect(Collectors.joining(",","prefix","subfix")));
        resetStream();
        //注意：这里返回类型与Collectors的返回类型一致
        Set<String> set2 = COMMON_STREAM.collect(Collectors.mapping(v -> v.toUpperCase(),Collectors.toSet()));
        System.out.println("set2 : " + set2.stream().collect(Collectors.joining(",")));
        resetStream();
        //参数说明：1、容纳结果的新容器 2、往新容器添加元素的操作 3、合并操作,操作类型需要与2保持一致，可以参考Collectors.toList操作逻辑
        List<String> resultList = COMMON_STREAM.collect(ArrayList::new,ArrayList::add,ArrayList::addAll);
        System.out.println("resultList : " + StringUtils.join(resultList,","));
        resetStream();
        String strResult = COMMON_STREAM.collect(StringBuffer::new,StringBuffer::append,StringBuffer::append).toString();
        System.out.println("strResult : " + strResult);

        //findAny,返回任意一个元素
        resetStream();
        Optional<String> optional = COMMON_STREAM.findAny();
        System.out.println("optional : " + optional.get());

        //find first
        resetStream();
        Optional<String> optional1 = COMMON_STREAM.findFirst();
        System.out.println("findFirst : " + optional1.get());

        //noneMatch
        resetStream();
        boolean noneMatchResult = COMMON_STREAM.noneMatch(v -> v.hashCode() == "g".hashCode());
        System.out.println(noneMatchResult);

        //allMatch
        resetStream();
        boolean allMatchResult = COMMON_STREAM.allMatch(v -> v.hashCode() > "c".hashCode());
        System.out.println(allMatchResult);

        //anyMatch
        resetStream();
        boolean anyMatchResult = COMMON_STREAM.anyMatch(v -> v.hashCode() >= "c".hashCode());
        System.out.println(anyMatchResult);

        //max,比较器需要自己定义
        Optional<Integer> maxInt = COMMON_INT_LIST.stream().max((v1, v2) -> v2 - v1);
        System.out.println(maxInt.get());

        //min与max类似
        Optional<Integer> minInt = COMMON_INT_LIST.stream().min((v1,v2) -> v1 - v2);
        System.out.println(minInt.get());

        //
    }

    private static void resetStream(){
        COMMON_STREAM = COMMON_STR_LIST.stream();
    }

}
