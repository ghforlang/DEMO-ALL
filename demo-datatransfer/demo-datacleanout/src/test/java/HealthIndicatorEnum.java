/*
 * Copyright (c) 2001-2018 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 健康指标数据
 *
 * @author guolinlin
 * @version V1.0
 * @since 2018-04-17 19:50
 */
public enum HealthIndicatorEnum {
    TEMPERATURE(1,"体温（摄氏度）","temperature"),
    BREATH(2,"呼吸频率（次/min）","respiratoryRate"),
    BLOOD_PRESSURE(3,"血压(mmHg)","bloodPressure"),
    PULSE_RATE(4,"脉搏（次/min）","pulseRate"),
    HEART_RATE(5,"心率 （次/min）","heartRate"),
    HEIGHT(6,"身高（cm）","height"),
    WEIGHT(7,"体重(kg）","weight"),
    BODY_MASS_INDEX(8,"BMI","bodyMassIndex"),
    BLOOD_SUGAR(9,"血糖","bloodSugar"),
    OXYGEN_SATURATION(10,"血氧饱和度（%）","oxygenSaturation"),
    WAIST(11,"腰围(cm)","waist"),
    BODY_FAT(12,"体脂率","bodyFat"),
    URIC_ACID(13,"尿酸","uricAcid"),
    TOTAL_CHOLESTEROL(14,"总胆固醇","totalCholesterol"),
    ACUTE_WEIGHT_GAIN(15,"每年急性增重","acuteWeightGainOfYear"),
    MMRC(16,"呼吸困难评估","mmrc"),
    FVC(17,"肺功能","pulmonaryFunction"),
    HEAD_CIRCUMFERENCE(18,"头围（cm）","headCircumference"),
    HUMAN_FAT(19,"人体脂肪","humanFat"),
    URINALYSIS(20,"尿检","urinalysis"),
    HBA1C(21,"糖化血红蛋白","hba1c"),
    BLOOD_FAT(22,"血脂","bloodFat"),
    HOMOCYSTEINE(23,"同型半胱氨酸","homocysteine"),
    ;

    private HealthIndicatorEnum(Integer bit, String desc,String indicatorName) {
        this.bit = bit;
        this.indicatorName = indicatorName;
        this.desc = desc;
    }

    private Integer bit;

    private String indicatorName;

    private String desc;



    public static final Map<String, HealthIndicatorEnum> CONTAINED_INDICATORS;
    public static final Map<String,Integer> CONTAINED_INDICATORS_MAP = new HashMap<>();

    static {
        Map<String, HealthIndicatorEnum> m = new HashMap<String, HealthIndicatorEnum>(HealthIndicatorEnum.values().length);
        for (HealthIndicatorEnum type : EnumSet.allOf(HealthIndicatorEnum.class)) {
            m.put(type.getIndicatorName(), type);
            CONTAINED_INDICATORS_MAP.put(type.indicatorName,type.bit);
        }
        CONTAINED_INDICATORS = m;
    }

    public static HealthIndicatorEnum of(String indicator) {
        return CONTAINED_INDICATORS.get(indicator);
    }

    public static Boolean contains(String indicator) {
        return CONTAINED_INDICATORS.containsKey(indicator);
    }

    public String getIndicatorName() {
        return indicatorName;
    }

    public void setIndicatorName(String indicatorName) {
        this.indicatorName = indicatorName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getBit() {
        return bit;
    }

    public void setBit(Integer bit) {
        this.bit = bit;
    }

    public Integer toDecimal(){
        return 1 << bit-1;
    }
}
