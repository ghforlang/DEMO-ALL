package com.edu.nbu.cn.test;

import com.edu.nbu.cn.function.DemoService;
import com.edu.nbu.cn.function.base.Param;
import com.edu.nbu.cn.function.base.Response;

/**
 * @author laoshi . hua
 * @version 1.0 2022/6/10-3:10 PM
 * @since 1.0
 */
public class DemoServiceTest {
    private static DemoService demoService = new DemoService();

    public static void main(String[] args) {
        String result = demoService.simpleDemoDeal("test1");
        Response response = demoService.demoDeal(new Param() {
            @Override
            public String resource() {
                return "one";
            }
        });
        System.out.println(result);
        System.out.println(response.getData());
    }
}
