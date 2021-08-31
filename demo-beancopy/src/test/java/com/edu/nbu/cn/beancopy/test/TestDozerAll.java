package com.edu.nbu.cn.beancopy.test;

import com.alibaba.fastjson.JSON;
import com.edu.nbu.cn.beancopy.dozer.DozerBeanUtils;
import com.edu.nbu.cn.beancopy.model.StudentBO;
import com.edu.nbu.cn.beancopy.model.StudentDTO;
import com.edu.nbu.cn.beancopy.model.simple.SimpleBean;
import com.edu.nbu.cn.beancopy.model.simple.SimpleBeanDTO;

public class TestDozerAll extends TestBase{

    private static StudentBO student = StudentBO.newInstance();
    private static SimpleBean simpleBean = SimpleBean.instance();

    private static String filePath = "dozer-demo-mapper.xml";

    public static void main(String[] args) {
        testSimple();
    }

    public static void testSimple(){
        long startTime = System.currentTimeMillis();
        SimpleBeanDTO dto1 = DozerBeanUtils.convert(simpleBean, SimpleBeanDTO.class);
        long time2 = System.currentTimeMillis();
        TestBase.print("timeCost : " + (time2 - startTime) + "ms  " + JSON.toJSONString(dto1));
        StudentDTO dto = DozerBeanUtils.convert(student,StudentDTO.class,filePath);
        TestBase.print("timeCost : " + (System.currentTimeMillis() - time2) + "ms  " + JSON.toJSONString(dto));
    }
}
