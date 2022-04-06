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
import java.util.List;

/**
 * 家族史
 */
@Data
public class FamilyHistory implements Serializable {
    private static final long serialVersionUID = -4319625252667926824L;

    /**
     * 是否 无殊
     * T-无殊 F-有
     */
    private String isNormal;

    /**
     * 补充内容
     */
    private String content;

    /**
     * 家族史明细
     */
    private List<FamilyHistoryItem> familyHistoryItems;

}
