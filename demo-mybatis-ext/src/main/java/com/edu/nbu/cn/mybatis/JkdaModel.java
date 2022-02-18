package com.edu.nbu.cn.mybatis;

import com.alibaba.excel.annotation.ExcelProperty;



/**
 * @author zhaogg
 * @version V1.0
 * @since 2022-02-14 21:57
 */
public class JkdaModel {

    @ExcelProperty(index = 0)
    private String a;

    @ExcelProperty(index = 1)
    private String b;

    @ExcelProperty(index = 2)
    private String c;

    @ExcelProperty(index = 3)
    private String d;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }
}
