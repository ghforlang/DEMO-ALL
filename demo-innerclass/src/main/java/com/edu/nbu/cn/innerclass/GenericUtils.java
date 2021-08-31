package com.edu.nbu.cn.innerclass;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 *
 * @version 1.0
 * @Date 2021/6/22 8:37 下午
 * @since 1.0
 */
@UtilityClass
public class GenericUtils {

    /**
     * 过滤满足条件的集合元素，支持类型转换，并返回，
     * @param collection
     * @param predicate
     * @param mapper
     * @param consumer
     * @param <S>
     * @param <R>
     * @return
     */
    public static <S,R> List<R> processCollection(Collection<S> collection, Predicate<S> predicate, Function<S,R> mapper, Consumer<R> consumer){
        List<R> result = new ArrayList<>();
        for(S s : collection){
            if(predicate.test(s)){
                R data = mapper.apply(s);
                consumer.accept(data);
                result.add(data);
            }
        }
        return result;
    }
}
