package com.edu.nbu.cn.beancopy.orikademo;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.CustomConverter;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BeanUtils {

    private static  MapperFactory mapperFactory;
    private static  ObjectMapper objectMapper;
    private static  PollutantSource source = buildSource();
    private static BoundMapperFacade<PollutantSource, PollutantSourceDTO> mapperFacade;
    private static final Map<String,String> propMap = new HashMap<>();
    private static final Map<String, CustomConverter> converterMap = new HashMap<>();



    static{
        System.setProperty("ma.glasnost.orika.GeneratedSourceCode.writeClassFiles","true");
        System.setProperty("ma.glasnost.orika.GeneratedSourceCode.writeSourceFiles","true");
        mapperFactory = new DefaultMapperFactory.Builder().build();

        propMap.putIfAbsent("socialCode","orgCode");
        propMap.putIfAbsent("longitude","geo.longitude");
        propMap.putIfAbsent("latitude","geo.latitude");
        propMap.putIfAbsent("gmtCreated","gmtCreated");
        propMap.putIfAbsent("name","name2");
        propMap.putIfAbsent("code","code2");

        converterMap.putIfAbsent(LocalDateTime2LongConverter.class.getCanonicalName(),new LocalDateTime2LongConverter());


        /* 注册类型转换器（全局）*/
        mapperFactory.getConverterFactory().registerConverter(new LocalDateTime2StringConverter());
        /* 注册类型转换器（非全局） */
        mapperFactory.getConverterFactory().registerConverter("LocalDateTime2Long", new LocalDateTime2LongConverter());
        /* 注册<PollutantSource.class,PollutantSourceDTO> 属性复制配置 */
        mapperFactory.classMap(PollutantSource.class, PollutantSourceDTO.class)
                .field("socialCode", "orgCode")  //非同名属性
                .field("longitude", "geo.longitude")  //导航属性
                .field("latitude", "geo.latitude")
                .field("xzqhs","xzqhs2")//导航属性
                .fieldMap("gmtCreated", "gmtCreated").converter("LocalDateTime2Long") // 这个属性使用 converter
                .add()
                .byDefault().register();
        /* 递归 */
        mapperFactory.classMap(Xzqh.class, Xzqh2.class)
                .field("name", "name2")
                .field("code", "code2")
                .byDefault().register();

        /* 通用的 MapperFacade ,屏蔽对mapperFactory 底层接口 */
//        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        /* 专用的 BoundMapperFacade<<PollutantSource, PollutantSourceDTO>> ,屏蔽对mapperFactory 底层接口*/
        mapperFacade =  mapperFactory.getMapperFacade(PollutantSource.class, PollutantSourceDTO.class);

    }

    public static void main(String[] args) {
        testConverter();
//        testExclude();
    }


    public static void testConverter(){
        PollutantSourceDTO sourceDTO = mapperFacade.map(source);
        System.out.println("sourceDTO : " + JSON.toJSONString(sourceDTO));

//        PollutantSource pollutantSource = mapperFacade.mapReverse(sourceDTO);
//        System.out.println("source: " + JSON.toJSONString(pollutantSource));
    }

    public static void testExclude(){
        mapperFactory.classMap(PollutantSource.class, PollutantSourceDTO.class).exclude("xzqhs").byDefault().register();
        mapperFacade = mapperFactory.getMapperFacade(PollutantSource.class,PollutantSourceDTO.class);

        PollutantSourceDTO sourceDTO = mapperFacade.map(source);
        System.out.println("sourceDTO : " + JSON.toJSONString(sourceDTO));

        PollutantSource pollutantSource = mapperFacade.mapReverse(sourceDTO);
        System.out.println("source: " + JSON.toJSONString(pollutantSource));
    }

    private static PollutantSource buildSource(){
        PollutantSource ps = new PollutantSource();
        ps.setAddresses(Arrays.asList("贵州省贵阳市花果园", "贵州省贵安新区马场镇", "贵州省遵义市"));
        ps.setGmtCreated(LocalDateTime.now());
        ps.setGmtModified(LocalDateTime.now());
        ps.setId("123123");
        ps.setLatitude("24.24");
        ps.setLongitude("110.10");
        ps.setSocialCode("520510500");
        ps.setXzqhs(Arrays.asList(new Xzqh("5201", "贵州省贵阳市"), new Xzqh("5203", "贵州省遵义市"), new Xzqh("529001", "贵州省贵安新区")));
        return ps;
    }
}
