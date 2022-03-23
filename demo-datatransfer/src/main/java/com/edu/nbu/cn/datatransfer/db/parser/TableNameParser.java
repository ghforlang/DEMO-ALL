package com.edu.nbu.cn.datatransfer.db.parser;

import com.edu.nbu.cn.datatransfer.exception.IllegalNameException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

/**
* @author laoshi . hua
* @since 1.0 
* @version 1.0 2022/3/22-3:54 下午
*/

public class TableNameParser extends NameParser{
    private static final String MODEL_PO_SUFIXX = "PO";

    public static String tableName2POJOClassName(String tableName){
        String pojoClassName = parseUnderlineName(tableName);
        pojoClassName = pojoClassName.substring(0,1).toUpperCase() + pojoClassName.substring(1) + MODEL_PO_SUFIXX;
        return pojoClassName ;
    }

    public static String columnName2FieldName(String columnName){
        System.out.println(columnName);
        return parseUnderlineName(columnName);
    }

    public static void main(String[] args) throws IOException {
        TableNameParser parser = new TableNameParser();
        String[] names = {"aaa","aaa_bbb","aaa_bbb_ccc","aaa_bbb_ccc_ddd"};
        for (int i=0;i<names.length;i++){
            System.out.println(parser.parse(names[i]));
        }

    }
}
