package com.edu.nbu.cn.datatransfer.db;

//import com.mysql.jdbc.DatabaseMetaData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/18-4:18 下午
 * @since 1.0
 */
@Component
public class TestConnection {
    @Autowired
    @Qualifier("customDataSource")
    private DataSource dataSource;



//    public Set<String> getAllColumns(String tableName) throws SQLException {
//        Set<String> columnNames = new HashSet<>();
//        DatabaseMetaData databaseMetaData = dataSource.getConnection().getMetaData();
//        ResultSet resultSet = databaseMetaData.getColumns(null,null,tableName+"%",null);
//        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
//        int count = resultSetMetaData.getColumnCount();
//        for(int i=1;i<=count;i++){
////            System.out.println("getCatalogName(int column) 获取指定列的表目录名称。"+resultSetMetaData.getCatalogName(i));
////            System.out.println("getColumnClassName(int column) 构造其实例的 Java 类的完全限定名称。"+resultSetMetaData.getColumnClassName(i));
////            System.out.println("getColumnCount()  返回此 ResultSet 对象中的列数。"+resultSetMetaData.getColumnCount());
////            System.out.println("getColumnDisplaySize(int column) 指示指定列的最大标准宽度，以字符为单位. "+resultSetMetaData.getColumnDisplaySize(i));
////            System.out.println("getColumnLabel(int column) 获取用于打印输出和显示的指定列的建议标题。 "+resultSetMetaData.getColumnLabel(i));
////            System.out.println("getColumnName(int column)  获取指定列的名称。"+resultSetMetaData.getColumnName(i));
////            System.out.println("getColumnType(int column) 获取指定列的 SQL 类型。 "+resultSetMetaData.getColumnType(i));
////            System.out.println("getColumnTypeName(int column) 获取指定列的数据库特定的类型名称。 "+resultSetMetaData.getColumnTypeName(i));
////            System.out.println("getPrecision(int column)  获取指定列的指定列宽。 "+resultSetMetaData.getPrecision(i));
////            System.out.println("getScale(int column) 获取指定列的小数点右边的位数。 "+resultSetMetaData.getScale(i));
////            System.out.println("getSchemaName(int column) 获取指定列的表模式。 "+resultSetMetaData.getSchemaName(i));
////            System.out.println("getTableName(int column) 获取指定列的名称。 "+resultSetMetaData.getTableName(i));
//            columnNames.add(resultSetMetaData.getColumnName(i));
//        }
//        return columnNames;
//    }
}
