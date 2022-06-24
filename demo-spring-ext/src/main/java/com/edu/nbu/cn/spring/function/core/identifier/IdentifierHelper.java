package com.edu.nbu.cn.spring.function.core.identifier;

import lombok.Getter;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author laoshi . hua
 * @version 1.0 2022/6/24-3:40 PM
 * @since 1.0
 */
public class IdentifierHelper {

    public static final String SEPARATOR = "-";
    private static final Map<String,IdentifierEntity> identifierEntityMap = new HashMap<>();

    public static String globalIdentifier(Class<?> serviceClass,String identifier){
        IdentifierEntity id = IdentifierEntity.build(identifier,serviceClass,serviceClass.getName());
        return id.identifier();
    }

    public static String serviceClassName(String globalIdentifier){
        return getIdentifierEntity(globalIdentifier).getServiceClassName();
    }

    public static String identifier(String globalIdentifier){
        return getIdentifierEntity(globalIdentifier).getIdentifier();
    }

    private static IdentifierEntity getIdentifierEntity(String globalIdentifier){
        if(StringUtils.isEmpty(globalIdentifier)){
            return null;
        }
        if(Objects.nonNull(identifierEntityMap.get(globalIdentifier))){
            return identifierEntityMap.get(globalIdentifier);
        }

        String[] identifiers = StringUtils.split(globalIdentifier,SEPARATOR);
        try {
            Class<?> clazz = Class.forName(identifiers[0]);
            IdentifierEntity id = IdentifierEntity.build(identifiers[1],clazz,identifiers[0]);
            identifierEntityMap.put(globalIdentifier,id);
            return id;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Getter
    static class IdentifierEntity{
        private String identifier;
        private Class<?> serviceClazz;

        private String serviceClassName;


        private IdentifierEntity(String identifier, Class<?> serviceClazz, String serviceClassName) {
            this.identifier = identifier;
            this.serviceClazz = serviceClazz;
            this.serviceClassName = serviceClassName;
        }

        private static   IdentifierEntity build(String identifier, Class<?> serviceClazz, String serviceClassName){
            return new IdentifierEntity(identifier,serviceClazz,serviceClassName);
        }

        public  String identifier(){
            return serviceClassName + SEPARATOR + identifier;
        }

    }
}
