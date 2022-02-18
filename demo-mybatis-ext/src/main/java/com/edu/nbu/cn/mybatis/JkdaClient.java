package com.edu.nbu.cn.mybatis;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.alibaba.fastjson.JSON;
import com.edu.nbu.cn.mybatis.utils.ExcelListener;


/**
 * @author zhaogg
 * @version V1.0
 * @since 2022-02-14 22:00
 */
public class JkdaClient {

    public static void main(String[] args) {
        ExcelListener<JkdaModel> listener = new ExcelListener<>();
        ExcelReader excelReader = EasyExcel.read("/Users/fanwenhao/my-projects/DEMO-ALL/demo-mybatis-ext/src/main/resources/解密表_1.xlsx", JkdaModel.class, listener).build();
        try {
            ReadSheet readSheet = EasyExcel.readSheet(0).build();
            excelReader.read(readSheet);
        } finally {
            excelReader.finish();
        }
        System.out.println(JSON.toJSONString(listener.getList()));
    }

}
