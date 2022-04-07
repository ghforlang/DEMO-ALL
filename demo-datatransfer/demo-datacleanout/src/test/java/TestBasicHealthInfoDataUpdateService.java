import com.edu.nbu.cn.data.cleanout.model.ehr.HealthInfo;
import com.edu.nbu.cn.data.cleanout.service.BasicHealthInfoDataUpdateService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author laoshi . hua
 * @version 1.0 2022/4/7-4:30 PM
 * @since 1.0
 */
public class TestBasicHealthInfoDataUpdateService extends BaseTest{

    @Autowired
    private BasicHealthInfoDataUpdateService basicHealthInfoDataUpdateService;

    private   List<HealthInfo> healthInfoList;

    @Before
    public void initHealthInfoList(){
        healthInfoList = basicHealthInfoDataUpdateService.searchAllHealthInfo();
    }

    @Test
    public void testUpdateExtraFields0(){
        basicHealthInfoDataUpdateService.updateExtraFields0(healthInfoList);
    }

    @Test
    public void testUpdateExtraFields2(){
        basicHealthInfoDataUpdateService.updateExtraFields2(healthInfoList);
    }


    @Test
    public void testUpdateExtraFields4(){
        basicHealthInfoDataUpdateService.updateExtraFields4(healthInfoList);
    }

}
