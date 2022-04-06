/*
 * Copyright (c) 2001-2018 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.edu.nbu.cn.data.cleanout.model.ehr;

import lombok.Data;

import java.io.Serializable;

/**
 * 家族史明细
 */
@Data
public class FamilyHistoryItem implements Serializable {
    private static final long serialVersionUID = -4319625212667926824L;

    /**
     * 人物code
     * 非特殊情况，该字段为空
     */
    private String whoCode;
    /**
     * 人物value
     * 非特殊情况，该字段为空
     */
    private String whoValue;

    /**
     * 时间
     * 非特殊情况，该字段为空
     */
    private String when;

    /**
     * 备注
     * 非特殊情况，该字段为空
     */
    private String remark;

}
