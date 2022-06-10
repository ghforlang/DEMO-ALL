package com.edu.nbu.cn.function;

import com.edu.nbu.cn.function.base.Param;
import com.edu.nbu.cn.function.base.Response;

/**
 * @author laoshi . hua
 * @version 1.0 2022/6/10-2:52 PM
 * @since 1.0
 */
public class DemoServiceExecutor {

    public Response demoOne(Param param){
        return Response.defaultResponse();
    }

    public Response demoTwo(Param param){
        return Response.defaultResponse();
    }

    public String simpleDemoOne(String type){
        return type + " success";
    }

    public String simpleDemoTwo(String type){
        return type + " success";
    }
}
