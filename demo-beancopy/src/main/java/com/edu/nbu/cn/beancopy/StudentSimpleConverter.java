package com.edu.nbu.cn.beancopy;

import com.edu.nbu.cn.beancopy.model.CourseEnum;
import com.edu.nbu.cn.beancopy.model.ScoreAndCourseBO;
import com.edu.nbu.cn.beancopy.model.ScoreAndCourseDTO;
import com.edu.nbu.cn.beancopy.model.StudentBO;
import com.edu.nbu.cn.beancopy.model.StudentDTO;
import org.apache.commons.collections.CollectionUtils;

import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

public class StudentSimpleConverter {

    public static StudentDTO convertToDTO(StudentBO student){
        if(null == student){
            return null;
        }

        StudentDTO dto = new StudentDTO();
        if(null != student.getBirthDay()){
            dto.setBirth(student.getBirthDay().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss SSS")));
        }
        dto.setId(student.getId().toString());
        dto.setName(student.getName());
        if(CollectionUtils.isNotEmpty(student.getScoreAndCourseBOList())){
            dto.setScoreAndCourseDTOList(student.getScoreAndCourseBOList().stream().map(courseBO -> convertToCourseDTO(courseBO)).collect(Collectors.toList()));
        }
       return dto;
    }

    private static ScoreAndCourseDTO convertToCourseDTO(ScoreAndCourseBO courseBO){
        if(null == courseBO){
            return null;
        }

        ScoreAndCourseDTO dto = new ScoreAndCourseDTO();
        dto.setScore(courseBO.getScore());
        CourseEnum courseEnum = CourseEnum.getByType(courseBO.getScoreType());
        if(null != courseEnum){
            dto.setScoreName(courseEnum.getCourseName());
        }
        return dto;
    }
}
