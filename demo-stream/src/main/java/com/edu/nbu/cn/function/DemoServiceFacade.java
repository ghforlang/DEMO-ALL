package com.edu.nbu.cn.function;

import com.edu.nbu.cn.constants.ResourceTypeEnum;
import com.edu.nbu.cn.function.base.Param;
import com.edu.nbu.cn.function.base.Response;

import java.util.Objects;
import java.util.function.Function;

/**
 * @author laoshi . hua
 * @version 1.0 2022/6/10-2:27 PM
 * @since 1.0
 */

public class DemoServiceFacade {
    private static DemoServiceExecutor serviceExecutor = new DemoServiceExecutor();

    static{
        FunctionFactory.register(ResourceTypeEnum.ONE.getResourceId(),param -> serviceExecutor.demoOne(param));
        FunctionFactory.register(ResourceTypeEnum.TWO.getResourceId(),param -> serviceExecutor.demoTwo(param));
        FunctionFactory.simpleRegister("test1",type -> serviceExecutor.simpleDemoOne(type));
        FunctionFactory.simpleRegister("test2",type -> serviceExecutor.simpleDemoTwo(type));
    }

    public Response demoDeal(Param param){
        Function<Param,Response> function = FunctionFactory.getByResourceId(param.resource());
        if(Objects.nonNull(function)){
            return function.apply(param);
        }
        return null;
    }

    public String simpleDemoDeal(String type){
        Function<String,String> function = FunctionFactory.simpleGet(type);
        if(Objects.nonNull(function)){
            return function.apply(type);
        }
        return "fail";
    }
}
