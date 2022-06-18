package com.edu.nbu.cn.spring.bean;

import com.edu.nbu.cn.spring.function.anno.FunctionBean;
import com.edu.nbu.cn.spring.function.anno.FunctionMethod;

/**
 * @author laoshi . hua
 * @version 1.0 2022/6/17-10:01 AM
 * @since 1.0
 */
@FunctionBean
public class ABizService implements BizService {

   @FunctionMethod(identifier = "a")
    public Result demoService(String identifier){
        return Result.successResult(identifier);
    }

    @Override
    public String getIdentifier() {
        return this.getClass().getSimpleName();
    }
}
