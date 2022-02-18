/*
 * Copyright (c) 2001-2018 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.edu.nbu.cn.mybatis.model.ehr;


import lombok.Data;

import java.util.List;

/**
 * 互斥组合
 * 类似于 过敏史、既往史
 *
 * @author guolinlin
 * @version V1.0
 * @since 2018-05-10 18:03
 */
@Data
public class MutexCombination {

    /**
     * 是否 无殊
     * T-无殊 F-有
     */
    private String isNormal;

    /**
     * 键值对
     */
    private List<CodedValue> codedValues;

    /**
     * 补充内容
     */
    private String content;

}
