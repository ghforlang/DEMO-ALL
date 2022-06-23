package com.edu.nbu.cn.spring.bean;

import com.edu.nbu.cn.spring.bean.function.ABizService;
import com.edu.nbu.cn.spring.bean.function.BBizService;
import com.edu.nbu.cn.spring.function.AbstractFunctionBeanHandler;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author laoshi . hua
 * @version 1.0 2022/6/18-2:26 PM
 * @since 1.0
 */

public class ServiceHelper extends AbstractFunctionBeanHandler {

    @Autowired
    private ABizService aBizService;
    @Autowired
    private BBizService bBizService;

    @Override
    public void afterPropertiesSet() throws Exception {
        registerABizFunction();
    }

    public void registerABizFunction(){
//        factory.register(aBizService.getClass(),aBizService.getIdentifier(),param -> aBizService.demoService(""));
//        factory.register(bBizService.getClass(),bBizService.getIdentifier(),param -> bBizService.demoService(""));
    }
}
