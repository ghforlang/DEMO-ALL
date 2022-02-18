/*
 * Copyright (c) 2001-2018 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.edu.nbu.cn.mybatis.model.ehr;

import lombok.Data;


/**
 * 常住地址
 *
 * @author Lydia
 * @version V1.0
 * @since 2018-07-12 14:55
 */
@Data
public class Address {

    /**
     * 省
     */
    private CodedValue province;
    /**
     * 市
     */
    private CodedValue city;
    /**
     * 区
     */
    private CodedValue county;
    /**
     * 乡（镇，街道）
     */
    private CodedValue township;
    /**
     * 村
     */
    private CodedValue village;
    /**
     * 地址
     */
    private String address;


}
