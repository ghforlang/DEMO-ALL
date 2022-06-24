package com.edu.nbu.cn.spring.function;


import com.edu.nbu.cn.spring.function.core.identifier.IdentifierHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.util.Map;
import java.util.function.Function;

/**
 * @author laoshi . hua
 * @version 1.0 2022/6/24-4:47 PM
 * @since 1.0
 */
public class SelectableFunction<R>{

    private  Map<String,Function<String,R>> candidateFunctions;
    private Class<?> executorClass;

    public SelectableFunction(Class<?> executorClass,Map<String,Function<String,R>> candidateFunctions) {
        this.executorClass = executorClass;
        this.candidateFunctions = candidateFunctions;
    }

    public R apply(String identifier) {
        if(CollectionUtils.isEmpty(candidateFunctions)){
            return null;
        }
        String globalIdentifier = IdentifierHelper.globalIdentifier(executorClass,identifier);
        return candidateFunctions.get(globalIdentifier).apply(identifier);
    }
}
