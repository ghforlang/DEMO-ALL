package com.edu.nbu.cn;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class FeeDTO implements Serializable {

    @JSONField(name="fee_name")
    private String feeName;
    @JSONField(name ="total_fee")
    private String totalFee;
    @JSONField(name="time",format = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private Date time;
    private String feeKind;
    private List<DetailFeeDTO> detailFeeList;

    public String getFeeName() {
        return feeName;
    }

    public void setFeeName(String feeName) {
        this.feeName = feeName;
    }

    public String getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(String totalFee) {
        this.totalFee = totalFee;
    }

    public String getFeeKind() {
        return feeKind;
    }

    public void setFeeKind(String feeKind) {
        this.feeKind = feeKind;
    }

    public List<DetailFeeDTO> getDetailFeeList() {
        return detailFeeList;
    }

    public void setDetailFeeList(List<DetailFeeDTO> detailFeeList) {
        this.detailFeeList = detailFeeList;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
