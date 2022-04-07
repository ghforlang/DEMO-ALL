package com.edu.nbu.cn.data.cleanout.mapper;

import com.edu.nbu.cn.data.cleanout.model.ehr.BasicHealthInfo;
import com.edu.nbu.cn.data.cleanout.model.ehr.BloodFatInfo;
import com.edu.nbu.cn.data.cleanout.model.ehr.HealthIndicator;
import com.edu.nbu.cn.data.cleanout.model.ehr.HealthIndicatorInfo;
import com.edu.nbu.cn.data.cleanout.model.ehr.HealthInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * @author laoshi . hua
 * @version 1.0 2022/4/7-9:55 AM
 * @since 1.0
 */
public interface CombinationMapper {

    void updateId(BasicHealthInfo basicHealthInfo);

    @Deprecated
    void updateIdCardNo(BasicHealthInfo basicHealthInfo);
    @Deprecated
    void updatePhoneNumber(BasicHealthInfo basicHealthInfo);

    void updateExtraFields(HealthInfo healthInfo);

    void updateExtraFields2(HealthInfo healthInfo);

    void updateExtraFields4(HealthInfo healthInfo);
    /**
     * 用于验证 updateExtraFields
     * @param peopleIds
     * @return
     */
    List<HealthInfo> listExtraFieldByPeopleIds(@Param("peopleIds") Set<String> peopleIds);

    /**
     * 用于验证 updateExtraFields2
     * @param peopleIds
     * @return
     */
    List<HealthInfo> listExtraField2ByPeopleIds(@Param("peopleIds") Set<String> peopleIds);

    /**
     * 用于验证updateExtraFields4
     * @param peopleIds
     * @return
     */
    List<HealthInfo> listExtraField4ByPeopleIds(@Param("peopleIds") Set<String> peopleIds);

    List<BasicHealthInfo> searchSimpleHealthInfo();

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
