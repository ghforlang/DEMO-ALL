package com.edu.nbu.cn.beancopy.dozer;

import org.dozer.DozerBeanMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;

public class DozerBeanUtils {
    private static final DozerBeanMapper mapper =  new DozerBeanMapper();

    /**
     * 简单beancopy
     * @param source
     * @param destClazz
     * @param <S>
     * @param <D>
     * @return
     */
    public static <S,D> D convert(S source,Class<D> destClazz){
        return mapper.map(source,destClazz);
    }

    /**
     * 通过xml mapper转化
     * @param source
     * @param destClazz
     * @param mapperFilePath
     * @param <S>
     * @param <D>
     * @return
     */
    public static <S,D> D convert(S source,Class<D> destClazz,String mapperFilePath){
        DozerBeanMapper dMapper =  new DozerBeanMapper();
        URL url = DozerDemo.class.getClassLoader().getResource(mapperFilePath);
        try {
            InputStream inputStream  = new FileInputStream(new File(url.getFile()));
            dMapper.addMapping(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return dMapper.map(source,destClazz);
    }

    public static <S,D> D convertT(S source,Class<D> destClazz){
        return null;
    }

}
