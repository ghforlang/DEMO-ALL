package com.edu.nbu.cn.demo.work.util;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author laoshi . hua
 * @version 1.0 2021/11/19-4:13 下午
 * @since 1.0
 */
@Setter
@Getter
public class API_55005 {
    private HospInfo hospInfo;
    private PatientInfo patientInfo;
    private OperatorInfo operatorInfo;
    private List<SettleItem> settleItemList;
    private Integer type;
}
