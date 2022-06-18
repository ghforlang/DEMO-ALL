package com.edu.nbu.cn.function;

import com.edu.nbu.cn.function.base.Param;
import com.edu.nbu.cn.function.base.Response;

/**
 * @author laoshi . hua
 * @version 1.0 2022/6/10-3:10 PM
 * @since 1.0
 */
public class DemoServiceTest {
    private static DemoServiceFacade demoServiceFacade = new DemoServiceFacade();

    public static void main(String[] args) {
        String result = demoServiceFacade.simpleDemoDeal("test1");
        Response response = demoServiceFacade.demoDeal(new Param() {
            @Override
            public String resource() {
                return "one";
            }
        });
        System.out.println(result);
        System.out.println(response.getData());
    }
}
