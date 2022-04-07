import com.edu.nbu.cn.data.cleanout.service.HealthIndicatorDataUpdateService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author laoshi . hua
 * @version 1.0 2022/4/7-6:52 PM
 * @since 1.0
 */
public class TestHealthIndicatorDataUpdateService extends BaseTest{

    @Autowired
    private HealthIndicatorDataUpdateService healthIndicatorDataUpdateService;

    @Test
    public void testGenerateBizLabelUpdateSql(){
        healthIndicatorDataUpdateService.generateBizLabelUpdateSql();
    }
}
