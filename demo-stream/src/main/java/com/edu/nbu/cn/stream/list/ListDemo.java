package com.edu.nbu.cn.stream.list;

import com.edu.nbu.cn.stream.constant.Constants;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Spliterator;

/**
 *
 * @version 1.0
 * @Date 2021/3/24 10:53 上午
 * @since 1.0
 */
public class ListDemo {

    public static void main(String[] args) {

        print(Constants.COMMON_INT_LIST);
        print(Constants.COMMON_STR_LIST);

        //spliterator 可拆分成两个list，一个是this，另一个是新的list，且两个list的元素不重复，减少；可批量迭代，减少迭代开销
        Spliterator<Integer> spliteratorIntList = Constants.COMMON_INT_LIST.spliterator();
        Spliterator<Integer> splitedIteratorIntList = spliteratorIntList.trySplit();
        spliteratorIntList.forEachRemaining(v -> System.out.print(v+ ","));
        System.out.println();
        splitedIteratorIntList.forEachRemaining(v -> System.out.print(v + ","));
        System.out.println();

        //replaceIf
        Constants.COMMON_STR_LIST.removeIf(v -> v == "a");
        Constants.COMMON_INT_LIST.removeIf(v -> v > 2);
        print(Constants.COMMON_INT_LIST);
        print(Constants.COMMON_STR_LIST);

        //replaceAll
        Constants.COMMON_STR_LIST.replaceAll(v -> v.toUpperCase());
        Constants.COMMON_INT_LIST.replaceAll(v -> v + 1);
        print(Constants.COMMON_STR_LIST);
        print(Constants.COMMON_INT_LIST);

        //sort
        Constants.COMMON_INT_LIST.sort((v1, v2) -> v2 - v1);
        print(Constants.COMMON_INT_LIST);
    }

    private static void print(List list){
        System.out.println(StringUtils.join(list,","));
    }
}
