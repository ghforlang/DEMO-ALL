package com.edu.nbu.cn.spring.function.core.identifier;

import lombok.experimental.UtilityClass;

/**
 * @author laoshi . hua
 * @version 1.0 2022/6/24-4:40 PM
 * @since 1.0
 */
@UtilityClass
public class Identifier {

    public static String identifierOfEnum(Enum enumIdentifier){
        return enumIdentifier.name();
    }

    public static String identifierOfInteger(Integer intIdentifier){
        return String.valueOf(intIdentifier);
    }

    public static String identifier(String string){
        return string;
    }
}
