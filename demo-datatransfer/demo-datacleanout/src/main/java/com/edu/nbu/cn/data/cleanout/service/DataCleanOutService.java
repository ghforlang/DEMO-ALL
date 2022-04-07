package com.edu.nbu.cn.data.cleanout.service;

import com.edu.nbu.cn.data.cleanout.model.ehr.BasicHealthInfo;
import com.edu.nbu.cn.data.cleanout.model.ehr.HealthInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author laoshi . hua
 * @version 1.0 2022/4/7-6:27 PM
 * @since 1.0
 */
@Component
public class DataCleanOutService {

    @Autowired
    private BasicHealthInfoDataUpdateService basicHealthInfoDataUpdateService;
    @Autowired
    private HealthIndicatorDataUpdateService healthIndicatorDataUpdateService;

    public  void  cleanOutBasicHealthInfo(){
        // 更新id为雪花id
        List<BasicHealthInfo>  basicHealthInfos = basicHealthInfoDataUpdateService.searchAllBasicHealthInfo();
        for (BasicHealthInfo basicHealthInfo : basicHealthInfos) {
            basicHealthInfoDataUpdateService.updateBasicHealthInfoId(basicHealthInfo);
        }

        // 其他字段更新
        List<HealthInfo> healthInfoList = basicHealthInfoDataUpdateService.searchAllHealthInfo();
        basicHealthInfoDataUpdateService.updateExtraFields0(healthInfoList);
        basicHealthInfoDataUpdateService.updateExtraFields2(healthInfoList);
        basicHealthInfoDataUpdateService.updateExtraFields4(healthInfoList);

    }

    public void generateBizLabelSql(){
        healthIndicatorDataUpdateService.generateBizLabelUpdateSql();
    }
}
