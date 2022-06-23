package com.edu.nbu.cn.spring.bean.function;

import com.edu.nbu.cn.spring.bean.Result;
import org.springframework.stereotype.Component;

/**
 * @author laoshi . hua
 * @version 1.0 2022/6/17-10:01 AM
 * @since 1.0
 */
@Component
public class ABizService implements BizService {

    public Result demoFunction(String param){
       System.out.println(this.getClass().getName() + " " + param);
        return Result.successResult(param);
    }
}
