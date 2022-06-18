package com.edu.nbu.cn.spring.bean;

import com.edu.nbu.cn.spring.function.anno.FunctionBean;
import com.edu.nbu.cn.spring.function.anno.FunctionMethod;

/**
 * @author laoshi . hua
 * @version 1.0 2022/6/18-4:41 PM
 * @since 1.0
 */
@FunctionBean
public class BBizService implements BizService{

    @Override
    public String getIdentifier() {
        return this.getClass().getSimpleName();
    }


    @FunctionMethod(identifier = "b")
    public Result demoService(String identifier){
        return Result.successResult(identifier);
    }
}
