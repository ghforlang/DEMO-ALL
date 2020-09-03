package com.edu.nbu.cn.beancopy.dozer;

import com.alibaba.fastjson.JSON;
import com.edu.nbu.cn.beancopy.dozer.converter.DozerLocalDateTime2StringConverter;
import com.edu.nbu.cn.beancopy.dozer.converter.DozerType2NameConverter;
import com.edu.nbu.cn.beancopy.model.ScoreAndCourseBO;
import com.edu.nbu.cn.beancopy.model.ScoreAndCourseDTO;
import com.edu.nbu.cn.beancopy.model.StudentBO;
import com.edu.nbu.cn.beancopy.model.StudentDTO;
import com.edu.nbu.cn.beancopy.model.simple.SimpleBean;
import com.edu.nbu.cn.beancopy.model.simple.SimpleBeanDTO;
import org.dozer.DozerBeanMapper;
import org.dozer.classmap.RelationshipType;
import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.TypeMappingOptions;

import java.time.LocalDateTime;

import static org.dozer.loader.api.FieldsMappingOptions.collectionStrategy;
import static org.dozer.loader.api.FieldsMappingOptions.customConverter;
import static org.dozer.loader.api.FieldsMappingOptions.hintA;
import static org.dozer.loader.api.FieldsMappingOptions.hintB;
import static org.dozer.loader.api.FieldsMappingOptions.useMapId;
import static org.dozer.loader.api.TypeMappingOptions.mapId;
import static org.dozer.loader.api.TypeMappingOptions.mapNull;

public class DozerDemo {

    private static StudentBO student = StudentBO.newInstance();
    private static SimpleBean simpleBean = SimpleBean.instance();

    private static String filePath = "dozer-demo-mapper.xml";

    public static void main(String[] args){
//        testSimpleBean();
//        testConvertByXML();
        testConvertByApi();
    }


    private static void testSimpleBean(){
        System.out.println(JSON.toJSONString(DozerBeanUtils.convert(simpleBean,SimpleBeanDTO.class)));
    }

    private static void testConvertByXML(){
        StudentDTO dto = DozerBeanUtils.convert(student,StudentDTO.class,filePath);
        System.out.println(JSON.toJSONString(dto));
    }

    private static void testConvertByApi() {
        BeanMappingBuilder builder =  new BeanMappingBuilder(){
            @Override
            protected void configure() {
                mapping(StudentBO.class, StudentDTO.class, TypeMappingOptions.oneWay(),mapId("a"),mapNull(true))
                        .fields("birthDay","birth",hintA(LocalDateTime.class),hintB(String.class),useMapId("a"),customConverter(DozerLocalDateTime2StringConverter.class))
                        .fields("scoreAndCourseBOList","scoreAndCourseDTOList",hintA(ScoreAndCourseBO.class),hintB(ScoreAndCourseDTO.class),useMapId("a"),collectionStrategy(true, RelationshipType.NON_CUMULATIVE));

                mapping(ScoreAndCourseBO.class, ScoreAndCourseDTO.class, TypeMappingOptions.oneWay(),mapId("b"),mapNull(true))
                        .fields("scoreType","scoreName",hintA(Integer.class),hintB(String.class),useMapId("b"),customConverter(DozerType2NameConverter.class));
            }
        };

        DozerBeanMapper mapper = new DozerBeanMapper();
        mapper.addMapping(builder);
        StudentDTO dto = mapper.map(student,StudentDTO.class);
        System.out.println(JSON.toJSONString(dto));
    }
}
