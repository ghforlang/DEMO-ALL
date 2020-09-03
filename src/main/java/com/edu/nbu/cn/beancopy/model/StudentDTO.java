package com.edu.nbu.cn.beancopy.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class StudentDTO {
    private String id;
    private String name;
    private String birth;

    private List<ScoreAndCourseDTO> scoreAndCourseDTOList;
}
