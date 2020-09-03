package com.edu.nbu.cn.beancopy.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class StudentBO {
    private Long id;
    private String name;
    private LocalDateTime birthDay;
    private List<ScoreAndCourseBO> scoreAndCourseBOList;

    /** just for test
     *
     * @return
     */
    public static final StudentBO newInstance(){
        StudentBO student = new StudentBO();
        student.setId(123L);
        student.setBirthDay(LocalDateTime.now());
        student.setName("张三");

        List<ScoreAndCourseBO> scoreAndCourseBOList = new ArrayList<>();
        ScoreAndCourseBO scoreAndCourseBO = new ScoreAndCourseBO();
        scoreAndCourseBO.setScoreType(1);
        scoreAndCourseBO.setScore("129.0");

        ScoreAndCourseBO scoreAndCourseBO2 = new ScoreAndCourseBO();
        scoreAndCourseBO2.setScoreType(2);
        scoreAndCourseBO2.setScore("110.5");
        scoreAndCourseBOList.add(scoreAndCourseBO);
        scoreAndCourseBOList.add(scoreAndCourseBO2);
        student.setScoreAndCourseBOList(scoreAndCourseBOList);
        return student;
    }
}
