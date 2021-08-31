package com.edu.nbu.cn.beancopy.test;

import com.alibaba.fastjson.JSON;
import com.edu.nbu.cn.beancopy.apache.StudentBeanCopyUtils;
import com.edu.nbu.cn.beancopy.model.StudentBO;
import com.edu.nbu.cn.beancopy.model.StudentDTO;
import com.edu.nbu.cn.beancopy.model.simple.SimpleBean;
import com.edu.nbu.cn.beancopy.model.simple.SimpleBeanDTO;
import com.edu.nbu.cn.beancopy.orika.converter.StudentBeanConverter;
import com.edu.nbu.cn.beancopy.orika.core.OrikaUtils;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

public class TestAll extends TestBase{

    private static StudentBO student = StudentBO.newInstance();
    private static SimpleBean simpleBean = SimpleBean.instance();

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
//        test1();
//        test2();
        testOrika2();
    }

    public static void test1() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        long startTime = System.currentTimeMillis();
        StudentDTO dto1 = testOrika();
        long time2 = System.currentTimeMillis();
        TestBase.print("timeCost : " + (time2 - startTime) + "ms  " + JSON.toJSONString(dto1));
        StudentDTO dto2 = testApacheBeanUtils();
        long time3 = System.currentTimeMillis();
        TestBase.print("timeCost : " + (time3 - time2) + "ms  " + JSON.toJSONString(dto2));
    }


    public static void test2() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        long startTime = System.currentTimeMillis();
        SimpleBeanDTO dto1 = testOrika2();
        long time2 = System.currentTimeMillis();
        TestBase.print("timeCost : " + (time2 - startTime) + "ms  " + JSON.toJSONString(dto1));
        SimpleBeanDTO dto2 = testApacheBeanUtils2();
        long time3 = System.currentTimeMillis();
        TestBase.print("timeCost : " + (time3 - time2) + "ms  " + JSON.toJSONString(dto2));
    }


    /**
     * orika 工具测试
     * @return
     */
    public static StudentDTO testOrika(){
        return StudentBeanConverter.convertToStudentDTO(student);
    }

    public static StudentDTO testApacheBeanUtils() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        return StudentBeanCopyUtils.copy(student);
    }

    public static SimpleBeanDTO testOrika2(){
        return OrikaUtils.map(simpleBean,SimpleBeanDTO.class);
    }

    public static SimpleBeanDTO testApacheBeanUtils2() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        SimpleBeanDTO simpleBeanDTO = new SimpleBeanDTO();
        BeanUtils.copyProperties(simpleBeanDTO,simpleBean);
        return simpleBeanDTO;
    }
}
