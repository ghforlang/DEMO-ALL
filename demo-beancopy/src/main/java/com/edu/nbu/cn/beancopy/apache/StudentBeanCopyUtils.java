package com.edu.nbu.cn.beancopy.apache;

import com.edu.nbu.cn.beancopy.model.ScoreAndCourseBO;
import com.edu.nbu.cn.beancopy.model.ScoreAndCourseDTO;
import com.edu.nbu.cn.beancopy.model.StudentBO;
import com.edu.nbu.cn.beancopy.model.StudentDTO;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.CollectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class StudentBeanCopyUtils {

    static{
        ConvertUtils.register(ApacheLocalDateTime2FormatStringConverter.getConverter(),String.class);
        ConvertUtils.register(ApacheCourseType2NameConverter.getConverter(),String.class);
    }

    public static StudentDTO copy(StudentBO studentBO) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        StudentDTO studentDTO = new StudentDTO();
        //简单属性copy
        BeanUtils.copyProperties(studentDTO,studentBO);
        //属性名、属性类型不同
        PropertyUtils.setProperty(studentDTO,"birth",ConvertUtils.convert(studentBO.getBirthDay()));

        //list
        List<ScoreAndCourseDTO> scoreAndCourseDTOList = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(studentBO.getScoreAndCourseBOList())){
            for(int i=0;i<studentBO.getScoreAndCourseBOList().size(); i++){
                ScoreAndCourseDTO courseDTO = new ScoreAndCourseDTO();
                ScoreAndCourseBO courseBO = (ScoreAndCourseBO)PropertyUtils.getIndexedProperty(studentBO,"scoreAndCourseBOList",i);
                BeanUtils.copyProperties(courseDTO,courseBO);
                PropertyUtils.setProperty(courseDTO,"scoreName",ConvertUtils.convert(courseBO.getScoreType()));
                scoreAndCourseDTOList.add(courseDTO);
            }
        }
        studentDTO.setScoreAndCourseDTOList(scoreAndCourseDTOList);
        return studentDTO;
    }

}
