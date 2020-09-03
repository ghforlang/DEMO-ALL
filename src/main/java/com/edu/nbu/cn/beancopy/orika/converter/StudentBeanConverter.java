package com.edu.nbu.cn.beancopy.orika.converter;

import com.edu.nbu.cn.beancopy.orika.core.OrikaRegisterCommonConverter;
import com.edu.nbu.cn.beancopy.orika.core.BeanConverter;
import com.edu.nbu.cn.beancopy.orika.core.OrikaConverterEnum;
import com.edu.nbu.cn.beancopy.orika.core.Triplet;
import com.edu.nbu.cn.beancopy.model.ScoreAndCourseBO;
import com.edu.nbu.cn.beancopy.model.ScoreAndCourseDTO;
import com.edu.nbu.cn.beancopy.model.StudentBO;
import com.edu.nbu.cn.beancopy.model.StudentDTO;
import ma.glasnost.orika.BoundMapperFacade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@UtilityClass
public class StudentBeanConverter extends BeanConverter {

    private static List<Triplet<String,String,String>> studentFieldsAndConverterIds = new ArrayList<>();
    private static List<Triplet<String,String,String>> courseFieldsAndConverterIds = new ArrayList<>();
    private static final Map<String, OrikaRegisterCommonConverter>  convertMap = new HashMap<>();
    private static final BoundMapperFacade<StudentBO,StudentDTO> boundMapperFacade;

    static{
        //初始化converter
        convertMap.putIfAbsent(OrikaConverterEnum.LOCAL_DATATIME_2_FORMAT_STRING.getCoverterId(),OrikaConverterEnum.LOCAL_DATATIME_2_FORMAT_STRING.getConverter());
        convertMap.putIfAbsent(OrikaConverterEnum.COURSE_TYPE_2_NAME.getCoverterId(),OrikaConverterEnum.COURSE_TYPE_2_NAME.getConverter());
        registerFieldConverter(convertMap);
        studentFieldsAndConverterIds.add(new Triplet<>("birthDay","birth",OrikaConverterEnum.LOCAL_DATATIME_2_FORMAT_STRING.getCoverterId()));
        studentFieldsAndConverterIds.add(new Triplet<>("scoreAndCourseBOList","scoreAndCourseDTOList",null));
        //复杂对象递归处理
        courseFieldsAndConverterIds.add(new Triplet<>("scoreType","scoreName",OrikaConverterEnum.COURSE_TYPE_2_NAME.getCoverterId()));
        registerFields(StudentBO.class, StudentDTO.class,studentFieldsAndConverterIds);
        registerFields(ScoreAndCourseBO.class, ScoreAndCourseDTO.class,courseFieldsAndConverterIds);
        boundMapperFacade = buildBoundMapperFacadeMapper(StudentBO.class,StudentDTO.class);
    }

    public static StudentDTO convertToStudentDTO(StudentBO student){
        return boundMapperFacade.map(student);
    }
}
