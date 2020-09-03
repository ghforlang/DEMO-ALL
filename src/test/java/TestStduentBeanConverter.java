import com.alibaba.fastjson.JSON;
import com.edu.nbu.cn.beancopy.orika.converter.StudentBeanConverter;
import com.edu.nbu.cn.beancopy.model.StudentBO;

public class TestStduentBeanConverter {
    public static void main(String[] args) {
        System.setProperty("ma.glasnost.orika.GeneratedSourceCode.writeSourceFiles","true");
//        System.setProperty("ma.glasnost.orika.GeneratedSourceCode.writeClassFiles","true");
       testMap();
       //classMap没有把scoreAndCourseBOList注册进去，导致生成的源码没有该属性；
    }

    public static void testMap(){
        StudentBO student =  StudentBO.newInstance();
        System.out.println(JSON.toJSONString(StudentBeanConverter.convertToStudentDTO(student)));
    }
}
