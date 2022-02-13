package com.edu.nbu.cn.demo.work.util;

import lombok.Getter;
import lombok.Setter;

/**
 * @author laoshi . hua
 * @version 1.0 2021/11/24-3:08 下午
 * @since 1.0
 */
@Getter
@Setter
public class SettleItem {
    private String miPrescriptionId;
    private String prescriptionId;
    private String miVisitId;
    private String ssSystemId;
    private String personalNo;
    private String prescriptionFlag;
    private String settleTime;
    private String miItemCode;
    private String itemCode;
    private Long totalPrice;
    private Integer amount;
    private Long price;
    private String takingWay;
    private String hospExamineFlag;
    private String medicalType;
    private String visitId;
    private String itemName;
    private String miItemType;
    private String commodityName;
    private HospDeptInfo hospDeptInfo;
}
