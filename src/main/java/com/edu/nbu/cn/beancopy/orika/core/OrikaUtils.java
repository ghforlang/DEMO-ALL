package com.edu.nbu.cn.beancopy.orika.core;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.Type;
import ma.glasnost.orika.metadata.TypeFactory;

import java.util.List;
import java.util.Map;

public class OrikaUtils {
    private static final MapperFactory factory =  new DefaultMapperFactory.Builder().build();
    private static final MapperFacade mapper = factory.getMapperFacade();

    /**
     * 简单的复制出新类型对象
     * @param source
     * @param destClazz
     * @param <S>
     * @param <D>
     * @return
     */
    public static <S,D> D map(S source,Class<D> destClazz){
        return mapper.map(source,destClazz);
    }


    /**
     * 极致性能的复制出新类型对象
     * @param source
     * @param sourceClass
     * @param destClazz
     * @param <S>
     * @param <D>
     * @return
     */
    public static <S,D> D map(S source,Class<S> sourceClass,Class<D> destClazz){
        return mapper.map(source,getType(sourceClass),getType(destClazz));
    }

    /**
     * 复制新对象列表到arrayList
     * @param sourceList
     * @param sourceClazz
     * @param destClazz
     * @param <S>
     * @param <D>
     * @return
     */
    public static <S,D> List<D> mapList(Iterable<S> sourceList, Class<S> sourceClazz, Class<D> destClazz){
        return mapper.mapAsList(sourceList,getType(sourceClazz),getType(destClazz));
    }

    /**
     * 简单复制出新对象列表到数组
     * @param destArray
     * @param sourceArray
     * @param destClazz
     * @param <S>
     * @param <D>
     * @return
     */
    public static<S,D> D[] mapArray(final D[] destArray,final S[] sourceArray,final Class<D> destClazz){
        return mapper.mapAsArray(destArray,sourceArray,destClazz);
    }


    /**
     * 极致性能的复制出新类型对象到数组
     * @param destArray
     * @param sourceArray
     * @param sourceClazz
     * @param destClazz
     * @param <S>
     * @param <D>
     * @return
     */
    public static<S,D> D[] mapArray(final D[] destArray,final S[] sourceArray,final Class<S> sourceClazz,final Class<D> destClazz){
        return mapper.mapAsArray(destArray,sourceArray,getType(sourceClazz),getType(destClazz));
    }

    public static<S,D> D map(Class<D> destClazz,S source,Map<String,String> propMap){
        return null;
    }



    public static <E> Type<E> getType(final Class<E> rawType){
        return TypeFactory.valueOf(rawType);
    }
}
