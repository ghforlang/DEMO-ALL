import com.edu.nbu.cn.data.cleanout.service.DataCleanOutService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author laoshi . hua
 * @version 1.0 2022/4/7-6:35 PM
 * @since 1.0
 */
public class TestDataCleanOutService extends BaseTest{

    @Autowired
    private DataCleanOutService dataCleanOutService;

    @Test
    public void testCleanOutBasicHealthInfo(){
        dataCleanOutService.cleanOutBasicHealthInfo();
    }
}
