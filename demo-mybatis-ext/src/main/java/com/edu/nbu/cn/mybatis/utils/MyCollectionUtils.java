package com.edu.nbu.cn.mybatis.utils;


import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MyCollectionUtils {
    /**
     * 从一个LIST中拷数据到另一个LIST中，
     * 下标从beginIndex到endIndex
     * 包括beginIndex，但不包括endIndex
     * @param src        原始集合
     * @param beginIndex 开始下标（含）
     * @param endIndex   结束的下标（不含)
     * @return
     *
     */
    public static <T> List<T> copyList(List<T> src, int beginIndex, int endIndex) {
        if (src == null || src.size() == 0) {
            return null;
        }

        if (beginIndex < 0) {
            throw new IllegalArgumentException("集合下标越界:" + beginIndex);
        }
        if (beginIndex > endIndex) {
            throw new IllegalArgumentException("集合下标设置错误:" + beginIndex);
        }
        int size = src.size();
        if (endIndex >= size) {
            endIndex = size;
        }
        List<T> result = new ArrayList<T>(endIndex - beginIndex);
        for (int i = beginIndex; i < endIndex; i++) {
            result.add(src.get(i));
        }
        return result;
    }

    /**
     * 从一个数组中拷数据到另一个数组中
     * 下标从beginIndex到endIndex
     * 包括beginIndex，但不包括endIndex
     * @param src        原始集合
     * @param beginIndex 开始下标（含）
     * @param endIndex   结束的下标（不含）
     * @return
     *
     */
    public static Object[] copyArray(Object[] src, int beginIndex, int endIndex) {
        if (src == null || src.length == 0) {
            return null;
        }

        if (beginIndex < 0) {
            throw new IllegalArgumentException("集合下标越界:" + beginIndex);
        }
        if (beginIndex > endIndex) {
            throw new IllegalArgumentException("集合下标设置错误:" + beginIndex);
        }

        if (endIndex >= src.length) {
            endIndex = src.length;
        }
        Object[] result = new Object[endIndex - beginIndex];
        for (int i = beginIndex; i < endIndex; i++) {
            result[i - beginIndex] = src[i];
        }
        return result;
    }

    /**
     * 判断集合是否为空，如果集合没有元素返回真，如果有NULL元素，返回FALSE
     * 否则返假
     * @param src
     * @return
     *
     */
    public static <T> boolean isEmpty(Collection<T> src) {
        if (src == null) {
            return true;
        }
        return src.isEmpty();
    }

    /**
     * 判断MAP是否为空，如果集合没有元素返回真  或都每个元素都是空，
     * 否则返假
     * @param src
     * @return
     *
     */
    public static <K, V> boolean isEmpty(Map<K, V> src) {
        if (src == null) {
            return true;
        }
        return src.isEmpty();
    }

    /**
     * 与isEmpty(Map)相反
     *
     *
     * @param src
     * @return
     *
     */
    public static <K, V> boolean isNotEmpty(Map<K, V> src) {
        return !isEmpty(src);
    }

    /**
     * 集合是否至少有一个非空元素
     *
     *
     * @param src
     * @return
     *
     */
    public static <T> boolean hasNotNullElement(Collection<T> src) {
        if (isEmpty(src)) {
            return false;
        }
        for (Object object : src) {
            if (object != null) {
                return true;
            }
        }
        return false;
    }

    /**
     * 集合是否至少有一个非空元素
     * @param src
     * @return
     *
     */
    public static boolean hasNotEmptyElement(Collection<String> src) {
        if (isEmpty(src)) {
            return false;
        }
        for (String object : src) {
            if (object != null && !"".equals(object.trim())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 是否所有元素为空或没有元素或集合为空
     * @param src
     * @return
     *
     */
    public static <T> boolean isAllElementsNull(Collection<T> src) {
        return !hasNotNullElement(src);
    }

    /**
     * 与isEmpty方法相反
     * @param src
     * @return
     *
     */
    public static <T> boolean isNotEmpty(Collection<T> src) {
        return !isEmpty(src);
    }

    /**
     * 只要有一个非空项即返回FALSE
     * @param src
     * @return
     *
     */
    public static boolean isEmpty(Object[] src) {
        if (src == null) {
            return true;
        }
        if (src.length == 0) {
            return true;
        }
        for (int i = 0; i < src.length; i++) {
            if (src[i] != null) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNotEmpty(Object[] src) {
        return !isEmpty(src);
    }


    /**
     * 复制集合数据
     * @param src    原集合
     * @param from   开始位置
     * @param length
     * @return
     *
     */
    public static <T> List<T> copySet(Set<T> src, int from, int length) {
        if (src == null) {
            return null;
        }
        List<T> result = new ArrayList<T>(length - from);
        int i = 0;
        for (T object : src) {
            if (i >= from && i < length) {
                result.add(object);
            }
            if (i >= length) {
                return result;
            }
            i++;
        }
        return result;
    }

    /**
     * 只要有一个非空与不等于空白项即返回FALSE
     * @param src
     * @return
     *
     */
    public static boolean isBlank(Object[] src) {
        if (src == null) {
            return true;
        }
        if (src.length == 0) {
            return true;
        }
        for (int i = 0; i < src.length; i++) {
            if (src[i] != null && src[i] != "") {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断字符串数组是否至少有1个不为空并且不是空字符串
     * @param propValue
     * @return
     *
     */
    public static boolean isEmpty(String[] propValue) {
        if (propValue == null) {
            return true;
        }
        if (propValue.length == 0) {
            return true;
        }
        for (int i = 0; i < propValue.length; i++) {
            if (StringUtils.isNotEmpty(propValue[i])) {
                return false;
            }
        }
        return true;
    }

    public static <T> List<T> removeDuplicate(List<T> list) {
        if (null != list) {
            Set<T> hashSet = new HashSet<T>(list);
            list.clear();
            list.addAll(hashSet);
        }
        return list;
    }

    public static List<Long> covertToLong(String[] strIds) {
        List<Long> indIds = new ArrayList<Long>(strIds.length);
        for (int i = 0; i < strIds.length; i++) {
            indIds.add(Long.valueOf(strIds[i]));
        }

        return indIds;
    }

    public static <T> List<List<T>> partition(List<T> list, int number) {
        return Lists.partition(list, number);
    }

    public static <T> Set<T> getCommonIdList(Set<T> setA, Set<T> setB) {
        if (CollectionUtils.isEmpty(setA) || CollectionUtils.isEmpty(setB)) {
            return Sets.newHashSet();
        }
        Predicate<T> condA = n -> setA.contains(n);
        Predicate<T> condB = n -> setB.contains(n);
        Set<T> set = new HashSet<>();
        set.addAll(setA);
        set.addAll(setB);
        return set.stream().filter(condA.and(condB)).collect(Collectors.toSet());
    }
}
