package com.edu.nbu.cn.datatransfer.generator;

import com.edu.nbu.cn.datatransfer.anno.Transfer;
import com.edu.nbu.cn.datatransfer.anno.TransferColumn;
import com.edu.nbu.cn.datatransfer.contants.TableType;
import com.edu.nbu.cn.datatransfer.db.DBTableHandler;
import com.edu.nbu.cn.datatransfer.db.metadata.ColumnMetaDataInfo;
import com.edu.nbu.cn.datatransfer.db.metadata.TableMetaDataInfo;
import com.edu.nbu.cn.datatransfer.db.parser.TableNameParser;
import com.edu.nbu.cn.datatransfer.exception.IllegalNameException;
import com.edu.nbu.cn.datatransfer.registry.TypeRegistry;
import com.google.common.collect.Maps;
import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.lang.model.element.Modifier;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/18-2:38 下午
 * @since 1.0
 */

@Component
public class JavaCodeGenerator extends AbstractGenerator<String,String>{

    @Autowired
    private DBTableHandler dbTableHandler;

    private static final Map<String,String> tableName2ClassNameMap = new HashMap<>();
    private static final Map<String,Map<String,POJOFieldMetaDataInfo>> tableColumn2POJOFieldMap = new HashMap<>();

    @PostConstruct
    public void initMethod(){
        // init tableName2ClassNameMap
        Set<String> allTableNames = dbTableHandler.allTableNames();
        for (String tableName : allTableNames) {
            tableName2ClassNameMap.put(tableName, TableNameParser.tableName2POJOClassName(tableName));
        }
        // init tableColumnNameMap
        Map<String, TableMetaDataInfo> tableMetaDataInfoMap = dbTableHandler.tableMetaDataInfoMap();
        tableMetaDataInfoMap.forEach((tableName,metaInfo) ->{
            tableColumn2POJOFieldMap.putIfAbsent(tableName, Maps.newHashMap());
            if(CollectionUtils.isNotEmpty(metaInfo.getColumnMetaDatas())){
                Map<String,POJOFieldMetaDataInfo> columnNameMap = tableColumn2POJOFieldMap.get(tableName);
                metaInfo.getColumnMetaDatas().forEach(columnMetaDataInfo -> {
                    columnNameMap.put(columnMetaDataInfo.getColumnName(),buildFiledMetaData(columnMetaDataInfo));
                });
            }
        });
//        System.out.println();
    }

    @SneakyThrows
    private POJOFieldMetaDataInfo buildFiledMetaData(ColumnMetaDataInfo columnData){
        POJOFieldMetaDataInfo fieldMetaDataInfo = new POJOFieldMetaDataInfo();
        fieldMetaDataInfo.setFieldName(TableNameParser.columnName2FieldName(columnData.getColumnName()));
        fieldMetaDataInfo.setFieldType(TypeRegistry.getFieldTypeWrapper(columnData.getColumnJdbcType()).getType());
        fieldMetaDataInfo.setComments(columnData.getComments());
        return fieldMetaDataInfo;
    }

    @Override
    public String generator(String s) {
        tableName2ClassNameMap.keySet().forEach(tableName ->{
            generateCode(tableName);
        });
        return s;
    }

    private void generateCode(String tableName){
        if(StringUtils.isBlank(tableName)){
            throw new IllegalNameException("illegal tableName when generate CODE!");
        }

        TypeSpec typeSpec = generateClassModel(tableName);
        String filePath = this.getClass().getResource("/").getPath();
        JavaFile file = JavaFile.builder("com.edu.nbu.cn.datatransfer.model",typeSpec).build();
        File abstractClazzFile = new File(filePath);
        try {
            file.writeTo(abstractClazzFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private TypeSpec generateClassModel(String tableName){
        if(StringUtils.isBlank(tableName)){
            return null;
        }
        List<FieldSpec> fieldSpecList = new ArrayList<>();
        TableMetaDataInfo tableMetaDataInfo = dbTableHandler.tableMetaDataInfoMap().get(tableName);
        tableMetaDataInfo.getColumnMetaDatas().forEach(columnMetaDataInfo -> {
            fieldSpecList.add(generateField(tableMetaDataInfo.getTableType(),columnMetaDataInfo));
        });


        AnnotationSpec annotationSpec = AnnotationSpec.builder(Transfer.class)
                .addMember("sourceType","$T.$L", TableType.class,tableMetaDataInfo.getTableType())
                .build();

        TypeSpec typeSpec = TypeSpec.classBuilder(tableName2ClassNameMap.get(tableName))
                .addAnnotation(annotationSpec)
                .addAnnotation(Getter.class)
                .addAnnotation(Setter.class)
                .addFields(fieldSpecList)
                .addModifiers(Modifier.PUBLIC)
                .build();
        return typeSpec;
    }

    private FieldSpec generateField(TableType tableType,ColumnMetaDataInfo columnMetaData){
        Map<String,POJOFieldMetaDataInfo> fieldMetaDataInfoMap = tableColumn2POJOFieldMap.get(columnMetaData.getTableName());
        POJOFieldMetaDataInfo fieldMetaDataInfo = fieldMetaDataInfoMap.get(columnMetaData.getColumnName());

        FieldSpec fieldSpec = FieldSpec.builder(fieldMetaDataInfo.getFieldType(),fieldMetaDataInfo.getFieldName())
                .addAnnotation(TransferColumn.class)
                .addJavadoc(fieldMetaDataInfo.getComments())
                .addModifiers(Modifier.PRIVATE)
                .build();
        return fieldSpec;
    }

    @Getter
    @Setter
    private static class POJOFieldMetaDataInfo{
        private String fieldName;
        private Class<?> fieldType;
        private String comments;
    }
}
