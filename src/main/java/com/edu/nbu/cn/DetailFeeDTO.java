package com.edu.nbu.cn;

import java.io.Serializable;

public class DetailFeeDTO implements Serializable {
    private String units;
    private String fee;
    private String itemSpace;
    private String clinicLabel;
    private String itemName;
    private String itemCode;
    private String amount;
    private String itemDetail;
    private String itemFeeDetail;

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getItemSpace() {
        return itemSpace;
    }

    public void setItemSpace(String itemSpace) {
        this.itemSpace = itemSpace;
    }

    public String getClinicLabel() {
        return clinicLabel;
    }

    public void setClinicLabel(String clinicLabel) {
        this.clinicLabel = clinicLabel;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getItemDetail() {
        return itemDetail;
    }

    public void setItemDetail(String itemDetail) {
        this.itemDetail = itemDetail;
    }

    public String getItemFeeDetail() {
        return itemFeeDetail;
    }

    public void setItemFeeDetail(String itemFeeDetail) {
        this.itemFeeDetail = itemFeeDetail;
    }
}
