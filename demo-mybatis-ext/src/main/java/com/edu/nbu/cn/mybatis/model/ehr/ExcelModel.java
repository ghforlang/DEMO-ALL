package com.edu.nbu.cn.mybatis.model.ehr;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * @author laoshi . hua
 * @version 1.0 2022/2/14-3:40 下午
 * @since 1.0
 */

public class ExcelModel {

    @ExcelProperty(index = 0)
    private String phoneNumber;
    @ExcelProperty(index = 1)
    private String idCardNo;
    @ExcelProperty(index = 2)
    private String phoneNumberDe;
    @ExcelProperty(index = 3)
    private String idCardNoDe;


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public String getPhoneNumberDe() {
        return phoneNumberDe;
    }

    public void setPhoneNumberDe(String phoneNumberDe) {
        this.phoneNumberDe = phoneNumberDe;
    }

    public String getIdCardNoDe() {
        return idCardNoDe;
    }

    public void setIdCardNoDe(String idCardNoDe) {
        this.idCardNoDe = idCardNoDe;
    }
}
