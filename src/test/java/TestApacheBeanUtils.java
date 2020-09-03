import com.alibaba.fastjson.JSON;
import com.edu.nbu.cn.beancopy.apache.StudentBeanCopyUtils;
import com.edu.nbu.cn.beancopy.model.StudentBO;
import com.edu.nbu.cn.beancopy.model.StudentDTO;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;

import java.lang.reflect.InvocationTargetException;

public class TestApacheBeanUtils {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        testCopyProperties();
        testBeanCompleteCopy();
        testBeanUtilsBean();
    }

    /**
     * 只能待处理同名同类型属性
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static void testCopyProperties() throws InvocationTargetException, IllegalAccessException {
        StudentBO studentBO = StudentBO.newInstance();
        StudentDTO studentDTO = new StudentDTO();
        BeanUtils.copyProperties(studentDTO,studentBO);
        System.out.println(JSON.toJSONString(studentDTO));
    }

    /**
     * 类型强转异常  result fail
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public static void testBeanUtilsBean() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        StudentBO studentBO = StudentBO.newInstance();
        StudentDTO studentDTO = (StudentDTO)BeanUtilsBean.getInstance().cloneBean(studentBO);
        System.out.println(JSON.toJSONString(studentDTO));
    }

    /**
     * complete converter
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     */
    public static void testBeanCompleteCopy() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        StudentBO studentBO = StudentBO.newInstance();
        StudentDTO studentDTO = StudentBeanCopyUtils.copy(studentBO);
        System.out.println(JSON.toJSONString(studentDTO));
    }
}
