package com.edu.nbu.cn.spring.executor;

import com.edu.nbu.cn.spring.bean.function.ABizService;
import com.edu.nbu.cn.spring.bean.Result;
import com.edu.nbu.cn.spring.function.core.anno.FunctionBean;
import com.edu.nbu.cn.spring.function.core.anno.FunctionMethod;

/**
 * @author laoshi . hua
 * @version 1.0 2022/6/22-4:38 PM
 * @since 1.0
 */
@FunctionBean
public class AExecutor  implements DemoExecutor {

    private ABizService aBizService = new ABizService();

    @Override
    @FunctionMethod(identifier = "a")
    public Result function(String param) {
        return aBizService.demoFunction(param);
    }

    @Override
    public boolean validIdentifier(String identifier) {
        return true;
    }
}
