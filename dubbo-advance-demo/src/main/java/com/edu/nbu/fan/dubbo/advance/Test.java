package com.edu.nbu.fan.dubbo.advance;

import com.edu.nbu.fan.dubbo.advance.config.DubboConfig;
import org.apache.dubbo.rpc.service.GenericService;
import org.springframework.util.CollectionUtils;

/**
 * @author laoshi . hua
 * @version 1.0 2022/10/21-5:30 PM
 * @since 1.0
 */
public class Test {
    public static void main(String[] args) {
        DubboConfig dubboConfig = new DubboConfig();
        GenericService genericService =  GenericServiceFactory.fetchGenericService(dubboConfig);
        Object obj = null;
        if(CollectionUtils.isEmpty(dubboConfig.getArgs())){
            obj = genericService.$invoke(dubboConfig.getMethod(),new String[0],new Object[0]);
        }else{
            DubboConfig.DubboMethodArgs methodArgs = new DubboConfig.DubboMethodArgs();
            methodArgs.setMethod(dubboConfig.getMethod());
            for(DubboConfig.Args arg : dubboConfig.getArgs()){
                methodArgs.addType(arg.getType());
                methodArgs.addValue(arg.getValue());
            }
            obj = genericService.$invoke(dubboConfig.getMethod(),methodArgs.getArgTypes().toArray(new String[0]), methodArgs.getArgValues().toArray(new Object[0]));
        }

        System.out.println(obj);

    }
}
