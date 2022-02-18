package com.edu.nbu.cn.mybatis.model.ehr;



/**
 * @author laoshi . hua
 * @version 1.0 2022/2/13-4:49 下午
 * @since 1.0
 */
public class BasicHealthInfo {

    private String peopleId;
    private String id;
    private String phoneNumber;
    private String idCardNo;
    private String name;


    public String getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(String peopleId) {
        this.peopleId = peopleId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
