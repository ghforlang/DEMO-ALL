import com.edu.nbu.cn.mybatis.application.Application;
import com.edu.nbu.cn.mybatis.mapper.EmployeesMapper;
import com.edu.nbu.cn.mybatis.model.Employees;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TestMapper {

    @Resource
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void testInterceptor(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmployeesMapper mapper = sqlSession.getMapper(EmployeesMapper.class);
        Employees employees = buildModel();
        mapper.insert(employees);
        sqlSession.close();
    }


    private static Employees buildModel(){
        Employees employees = new Employees();
        employees.setBirthDate(new Date());
        employees.setFirstName("zhang");
        employees.setLastName("san");
        employees.setGender(1);
        employees.setHireDate(new Date());
        return employees;
    }

}
