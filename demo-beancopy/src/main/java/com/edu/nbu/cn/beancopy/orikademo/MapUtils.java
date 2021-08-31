package com.edu.nbu.cn.beancopy.orikademo;

import lombok.experimental.UtilityClass;
import ma.glasnost.orika.CustomConverter;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.ClassMapBuilder;
import ma.glasnost.orika.metadata.Type;
import ma.glasnost.orika.metadata.TypeFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@UtilityClass
public class MapUtils {

    private static final Map<String,MapperFacade> mapperFacadeCacheMap  = new ConcurrentHashMap<>();
    private static final Map<String, CustomConverter<Object,Object>> converterMap = new ConcurrentHashMap<>();
    private static final MapperFacade mapper;
    private static final MapperFactory factory;
    private static final Set<CustomConverter> globalConverterSet = new HashSet<>();

    static{
        factory = new DefaultMapperFactory.Builder().build();
        mapper = factory.getMapperFacade();
        globalConverterSet.add(new LocalDateTime2StringConverter());
    }


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
    public static <S,D> List<D> mapList(Iterable<S> sourceList,Class<S> sourceClazz,Class<D> destClazz){
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

    private static <S,D> MapperFacade getMapperFacade(Class<S> sourceClazz,Class<D> destClazz,Map<String,String> propMap,Map<String,CustomConverter<Object,Object>> converterMap){
        String mapperKey = sourceClazz.getCanonicalName() + "_" + destClazz.getCanonicalName();
        MapperFacade mapperFacade = mapperFacadeCacheMap.get(mapperKey);
        if(Objects.isNull(mapperFacade)){
            Set<Object> convertSet = new HashSet<>(converterMap.values());
            convertSet.forEach( v -> factory.getConverterFactory().registerConverter(v.getClass().getCanonicalName(),(CustomConverter)v));
            ClassMapBuilder<S,D> classMapBuilder = factory.classMap(sourceClazz,destClazz);
            propMap.forEach((pro1,pro2) ->{
                if(Objects.nonNull(converterMap.get(pro1))){
                    classMapBuilder.fieldMap(pro1,pro2).converter(converterMap.get(pro1).getClass().getCanonicalName());
                }else{
                    classMapBuilder.field(pro1,pro2);
                }
            });
            propMap.forEach(classMapBuilder::field);
            classMapBuilder.byDefault().register();
            mapperFacade =  factory.getMapperFacade();
            mapperFacadeCacheMap.putIfAbsent(mapperKey,mapperFacade);
        }
        return mapperFacade;
    }

}
