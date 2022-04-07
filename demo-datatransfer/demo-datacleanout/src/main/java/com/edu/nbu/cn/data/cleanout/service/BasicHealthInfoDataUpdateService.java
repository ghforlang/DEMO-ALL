package com.edu.nbu.cn.data.cleanout.service;

import com.edu.nbu.cn.data.cleanout.model.ehr.BasicHealthInfo;
import com.edu.nbu.cn.data.cleanout.model.ehr.HealthInfo;

import java.util.List;

/**
 * @author laoshi . hua
 * @version 1.0 2022/4/7-10:21 AM
 * @since 1.0
 */
public interface BasicHealthInfoDataUpdateService {

    /**
     * 更新基本信息id为雪花id
     * @param basicHealthInfo
     */
    void updateBasicHealthInfoId(BasicHealthInfo basicHealthInfo);

    /**
     * 查询所有基本健康信息
     * @return
     */
    List<BasicHealthInfo> searchAllBasicHealthInfo();

    /**
     * 查询所有基本健康信息
     * @return
     */
    List<HealthInfo> searchAllHealthInfo();

    void updateExtraFields0(List<HealthInfo> healthInfoList);

    void updateExtraFields2(List<HealthInfo> healthInfoList);

    void updateExtraFields4(List<HealthInfo> healthInfoList);
}
