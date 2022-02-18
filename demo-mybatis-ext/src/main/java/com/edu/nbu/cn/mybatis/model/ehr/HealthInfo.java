package com.edu.nbu.cn.mybatis.model.ehr;

import lombok.Getter;
import lombok.Setter;

/**
 * @author laoshi . hua
 * @version 1.0 2022/2/15-11:06 上午
 * @since 1.0
 */

@Getter
@Setter
public class HealthInfo extends BasicHealthInfo{
    private String aboBloodTypeName;
    private String aboBloodTypeId;
    private String rhBloodTypeName;
    private String rhBloodTypeId;

    private String martialStatusId;
    private String martialStatusName;

    private String fertilityStatusId;
    private String fertilityStatusName;

    private String familyDiseases;
    private String familyHistoryIsNormal;

    private String dietTasteList;
    private String dietTasteIsNormal;

    private String respiratoryRate;

    private String sportFrequencyName;
    private String sportFrequencyId;

    private String sleepingSituationId;
    private String sleepingSituationName;

    private String pastIllnessIsNormal;
    private String pastDiseases;

    private String smokingStatusId;
    private String smokingStatusName;

    private String drinking_status_name;
    private String drinking_status_id;

    private String sleeping_hours_id;
    private String sleeping_hours_code;

    private String province_id;
    private String province_name;
    private String city_id;
    private String city_name;
    private String county_id;
    private String county_name;
    private String township_id;
    private String township_name;
    private String village_id;
    private String village_name;
    private String address;







}
