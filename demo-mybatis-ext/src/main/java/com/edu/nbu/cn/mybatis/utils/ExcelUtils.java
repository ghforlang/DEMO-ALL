package com.edu.nbu.cn.mybatis.utils;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.edu.nbu.cn.mybatis.model.ehr.ExcelModel;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * @author laoshi . hua
 * @version 1.0 2022/2/14-3:40 下午
 * @since 1.0
 */
public class ExcelUtils {

    private static final String excelPath = "/Users/fanwenhao/my-projects/DEMO-ALL/demo-mybatis-ext/src/main/resources/解密表的副本.xlsx";
    private static final String jsonPath = "/Users/fanwenhao/my-projects/DEMO-ALL/demo-mybatis-ext/src/main/resources/en_decrypt_json.json";

    public static  List<ExcelModel> importExcel(String path) {
        ExcelListener<ExcelModel> listener = new ExcelListener<>();
        ExcelReader excelReader = EasyExcel.read(path, ExcelModel.class, listener).build();
        try {
            ReadSheet readSheet = EasyExcel.readSheet(0).build();
            excelReader.read(readSheet);
        } finally {
            excelReader.finish();
        }
        return listener.getList();
    }

    //写文件
    private static String writeJsonfile(String content, String filePath){
        try {
            FileUtils.writeStringToFile(new File(filePath), content, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }

    public static void main(String[] args) {
        List<ExcelModel> modelList = importExcel(excelPath);
        writeJsonfile(JSON.toJSONString(modelList),jsonPath);
    }


    public static List<ExcelModel> readModelFromJson(String jsonPath){
        String jsonStr = readJsonFile(jsonPath);
        return  JSONObject.parseArray(jsonStr,ExcelModel.class);
    }

    //读取文件
    private static String readJsonFile( String filePath) {
        String content = null;
        try {
            content = FileUtils.readFileToString(new File(filePath), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}
