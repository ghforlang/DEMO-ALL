package com.edu.nbu.cn.data.cleanout.mapper;


import com.edu.nbu.cn.data.cleanout.model.ehr.BasicHealthInfo;
import com.edu.nbu.cn.data.cleanout.model.ehr.BloodFatInfo;
import com.edu.nbu.cn.data.cleanout.model.ehr.HealthIndicator;
import com.edu.nbu.cn.data.cleanout.model.ehr.HealthIndicatorInfo;
import com.edu.nbu.cn.data.cleanout.model.ehr.HealthInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author laoshi . hua
 * @version 1.0 2022/2/13-4:56 下午
 * @since 1.0
 */
public interface BasicHealthInfoMapper {

    void updateId(BasicHealthInfo basicHealthInfo);

    void updateIdCardNo(BasicHealthInfo basicHealthInfo);

    void updatePhoneNumber(BasicHealthInfo basicHealthInfo);

    void updateExtraFields(HealthInfo healthInfo);

    void updateExtraFields4(HealthInfo healthInfo);

    void updateExtraFields2(HealthInfo healthInfo);

    List<BasicHealthInfo> search();

    List<HealthInfo> searchHealthInfo();

    //血脂
    void updateBloodFat(BloodFatInfo fatInfo);

    List<BloodFatInfo> listFat(@Param("peopleId") String peopleId);

    // 健康指标
    void updateHealthIndicatorInfo(HealthIndicatorInfo indicatorInfo);

    List<HealthIndicatorInfo> list(@Param("bizIds")List<String> bizIds);


    List<HealthIndicator> searchBizLabelsAll();

    void updateBizLabelsData(HealthIndicator healthIndicator);
}
