package com.edu.nbu.cn.beancopy.orika.core;


import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.ConverterFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.ClassMapBuilder;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

public class BeanConverter {
    private static final MapperFactory mapperFactory;
    private static final ConverterFactory converterFactory;

    static{
        mapperFactory = new DefaultMapperFactory.Builder().build();
        converterFactory = mapperFactory.getConverterFactory();
    }

    public static <S,D> void registerFields(final Class<S> sourceClazz, final Class<D> destClazz, List<Triplet<String,String,String>> copyTriplets){
        ClassMapBuilder<S,D> classMapBuilder = mapperFactory.classMap(sourceClazz,destClazz);
        if(CollectionUtils.isEmpty(copyTriplets)){
            return;
        }
        copyTriplets.forEach(copyTriplet -> {
            if(StringUtils.isNotBlank(copyTriplet.getThird())){
                classMapBuilder.fieldMap(copyTriplet.getFirst(), copyTriplet.getSecond()).converter(copyTriplet.getThird()).add();
            }else{
                classMapBuilder.fieldMap(copyTriplet.getFirst(), copyTriplet.getSecond()).add();
            }
        });
        classMapBuilder.byDefault().register();
    }

    public static void registerFieldConverter(Map<String, OrikaRegisterCommonConverter> converterMap){
        if(MapUtils.isNotEmpty(converterMap)){
            converterMap.forEach(converterFactory::registerConverter);
        }
    }

    public static <S,D> BoundMapperFacade<S,D> buildBoundMapperFacadeMapper(final Class<S> sourceClazz, final Class<D> targetClazz){
        return mapperFactory.getMapperFacade(sourceClazz,targetClazz);
    }
}
