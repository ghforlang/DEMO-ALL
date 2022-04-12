package com.edu.nbu.fan.gen;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author laoshi . hua
 * @version 1.0 2022/4/11-10:55 AM
 * @since 1.0
 */
public class Test {

    private static final Map<String,String> fieldMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        String filePath = Thread.currentThread().getContextClassLoader().getClass().getResource("/").getPath() + "basic_health_info_sqlField.txt";
        String sqlFields = FileUtils.readFileToString(new File(filePath),"UTF-8");
        String[] sqlArr = StringUtils.split(sqlFields,"|");
        String[] tarSqlFields = StringUtils.split(sqlArr[0],",");
        String[] srcSqlFields = StringUtils.split(sqlArr[0],",");
        if(tarSqlFields.length != srcSqlFields.length){
            System.out.println("字段中有无效字段，请检查");
        }
        for(int i=0;i<tarSqlFields.length;i++){
            fieldMap.putIfAbsent(StringUtils.remove(tarSqlFields[i],"\n"),StringUtils.remove(srcSqlFields[i],"\n"));
        }

        fieldMap.forEach((k,v) ->{
            System.out.println(k + "," + v);
        });
    }
}
