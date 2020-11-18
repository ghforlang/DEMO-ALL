package com.edu.nbu.cn.beancopy;

import com.edu.nbu.cn.beancopy.model.StudentBO;
import com.edu.nbu.cn.beancopy.model.simple.SimpleBean;

public class BeanCopy {

    public static void main(String[] args) throws CloneNotSupportedException {

        SimpleBean simpleBean = new SimpleBean();
        simpleBean.setId(12321L);
        simpleBean.setName("simpleBean");
        simpleBean.setUuid("123135alxojgoasfl2os");
        System.out.println("**************************************************************");
        SimpleBean copiedBean =  simpleBean;
        System.out.println("simpleBean$" + copiedBean.hashCode() + ",copiedBean$" + copiedBean.hashCode());
        copiedBean.setName("copiedBean");
        System.out.println("simpleBean : ");
        System.out.println(simpleBean);
        System.out.println("copiedBean");
        System.out.println(copiedBean);
        System.out.println("**************************************************************");

        SimpleBean clonedBean = (SimpleBean)simpleBean.clone();
        System.out.println(clonedBean);
        System.out.println("simpleBean$" + copiedBean.hashCode() + ",clonedBean$" + clonedBean.hashCode());

        System.out.println("**************************************************************");

        StudentBO student = StudentBO.newInstance();
        System.out.println(student);

        StudentBO  clonedStudent = (StudentBO)student.clone();
        System.out.println("student$" + student.hashCode() + ",clonedStudent$" + clonedStudent.hashCode());
        System.out.println("student.name" + student.getName().hashCode() + ",clonedStudent.name$" + clonedStudent.getName().hashCode());
        System.out.println("student.birthDay$" + student.getBirthDay().hashCode() + ",clonedStudent.birthday$" + clonedStudent.getBirthDay().hashCode());
        System.out.println("student.scoreAndCourseBOList" + student.getScoreAndCourseBOList().hashCode() + ",clonedStudent.scoreAndCourseBOList" + clonedStudent.getScoreAndCourseBOList().hashCode());
    }
}
