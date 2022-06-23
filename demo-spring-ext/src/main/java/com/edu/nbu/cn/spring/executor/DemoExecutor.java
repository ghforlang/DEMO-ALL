package com.edu.nbu.cn.spring.executor;

import com.edu.nbu.cn.spring.bean.Result;
import com.edu.nbu.cn.spring.function.core.anno.FunctionInterface;

/**
 * @author laoshi . hua
 * @version 1.0 2022/6/22-4:37 PM
 * @since 1.0
 */
@FunctionInterface
public interface DemoExecutor extends Executor<String>{
    /**
     *
     * @param param
     * @return
     */
    Result function(String param);
}
