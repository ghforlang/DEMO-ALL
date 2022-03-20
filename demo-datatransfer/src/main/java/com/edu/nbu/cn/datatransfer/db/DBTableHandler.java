package com.edu.nbu.cn.datatransfer.db;

import com.edu.nbu.cn.datatransfer.db.metadata.ColumnMetaDataInfo;
import com.edu.nbu.cn.datatransfer.db.metadata.TableMetaDataInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/20-11:27 上午
 * @since 1.0
 */
@Component
public class DBTableHandler {

    @Autowired
    @Qualifier("customDataSource")
    private DataSource dataSource;

    private static final String DB_SCHEMA = "TTT";
    private static final String TABLE_NAME = "TABLE_NAME";
    private static final String COLUMN_QURY_SQL = "SELECT TABLE_NAME,COLUMN_NAME,COLUMN_DEFAULT,IS_NULLABLE,DATA_TYPE,CHARACTER_MAXIMUM_LENGTH,COLUMN_TYPE,COLUMN_COMMENT FROM COLUMNS WHERE TABLE_NAME = ";

    public Set<String> allTableNames(){
        Set<String> tableNames = new HashSet<>();
        Statement statement = null;
        try {
            statement = dataSource.getConnection().createStatement();
            ResultSet tables = statement.executeQuery("SELECT TABLE_NAME FROM `COLUMNS` WHERE TABLE_SCHEMA = " + "'" + DB_SCHEMA + "'") ;
            while(tables.next()){
                tableNames.add(tables.getString(1));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return tableNames;
    }

    public List<TableMetaDataInfo> listTables(){
        List<TableMetaDataInfo> tableMetaDataInfos = new ArrayList<>();
        Set<String> tableNames = allTableNames();
        for (String tableName : tableNames){
            tableMetaDataInfos.add(buildTableMetaDataInfo(tableName));
        }
        return tableMetaDataInfos;
    }

    private TableMetaDataInfo buildTableMetaDataInfo(String tableName){
        TableMetaDataInfo tableMetaDataInfo = new TableMetaDataInfo();
        tableMetaDataInfo.setTableName(tableName);
        Statement descStatement = null;
        try {
            descStatement = dataSource.getConnection().createStatement();
            ResultSet resultSet = descStatement.executeQuery(COLUMN_QURY_SQL + "'" + tableName + "'");
            List<ColumnMetaDataInfo> columnMetaDataInfos = new ArrayList<>();
            int orderValue = 1;
            while(resultSet.next()){
                ColumnMetaDataInfo columnMetaDataInfo = new ColumnMetaDataInfo();
                columnMetaDataInfo.setTableName(resultSet.getString(1));
                columnMetaDataInfo.setColumnName(resultSet.getString(2));
                columnMetaDataInfo.setColumnDefault(resultSet.getString(3));
                columnMetaDataInfo.setNullable(StringUtils.isBlank(resultSet.getString(4)) ? true : ("YES".equalsIgnoreCase(resultSet.getString(4)) ? true : false));
                columnMetaDataInfo.setColumnJdbcType(resultSet.getString(5));
//                columnMetaDataInfo.setColumnType(Class.forName(convertType(resultSet.getString(2))));
                columnMetaDataInfo.setComments(resultSet.getString(8));

                columnMetaDataInfo.setOrder(orderValue++);
                columnMetaDataInfos.add(columnMetaDataInfo);
            }
            tableMetaDataInfo.setColumnMetaDatas(columnMetaDataInfos);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return tableMetaDataInfo;
    }

   private  String convertType(String sqlType) {
        if (sqlType.startsWith("varchar")){
            return "java.lang.String";
        }
        if (sqlType.startsWith("bigint")){
            return "java.lang.Long";
        }
        if (sqlType.startsWith("int")){
            return "java.lang.Integer";
        }
        if (sqlType.startsWith("smallint")) {
            return "java.lang.Short";
        }
        if (sqlType.startsWith("tinyint")) {
            return "java.lang.Byte";
        }
        if(sqlType.startsWith("double")) {
            return "java.lang.Double";
        }
        if(sqlType.startsWith("timestamp") || sqlType.startsWith("TIMESTAMP")){
            return "java.time.LocalDateTime";
        }
        return null;
    }

}
