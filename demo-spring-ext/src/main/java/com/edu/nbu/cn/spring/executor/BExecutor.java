package com.edu.nbu.cn.spring.executor;

import com.edu.nbu.cn.spring.bean.function.BBizService;
import com.edu.nbu.cn.spring.bean.Result;
import com.edu.nbu.cn.spring.function.core.anno.FunctionBean;
import com.edu.nbu.cn.spring.function.core.anno.FunctionMethod;

/**
 * @author laoshi . hua
 * @version 1.0 2022/6/22-4:40 PM
 * @since 1.0
 */
@FunctionBean
public class BExecutor implements DemoExecutor {


    private BBizService bBizService = new BBizService();

    @Override
    @FunctionMethod(identifier = "b")
    public Result function(String param) {
        return bBizService.demoFunction(param);
    }

    @Override
    public boolean validIdentifier(String identifier) {
        return true;
    }
}
