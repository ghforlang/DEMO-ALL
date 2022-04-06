package com.edu.nbu.cn.data.cleanout.model.ehr;

/**
 * @author laoshi . hua
 * @version 1.0 2022/2/15-11:15 上午
 * @since 1.0
 */
public class CodedValue {

    /**
     * 编码
     */
    private String code;
    /**
     * 值
     */
    private String value;

    public CodedValue(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
