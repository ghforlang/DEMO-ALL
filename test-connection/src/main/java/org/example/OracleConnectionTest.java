package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author laoshi . hua
 * @version 1.0 2024/5/28-14:48
 * @since 1.0
 */
public class OracleConnectionTest {

    public static boolean isConnected(){
        // Oracle数据库的JDBC URL
        String jdbcUrl = "jdbc:oracle:thin:@10.92.87.140:1521:orcl";
        String username = "ktcm_ao";
        String password = "kingthis";

        try {
            // 加载Oracle JDBC驱动
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // 建立连接
            Connection conn = DriverManager.getConnection(jdbcUrl, username, password);

            // 创建Statement对象来执行SQL语句
            Statement statement = conn.createStatement();

            // 执行查询并获取结果
            ResultSet resultSet = statement.executeQuery("SELECT * FROM TCM_TONGUE");

            // 处理结果
            while (resultSet.next()) {
                // 根据你的表结构，获取并打印字段
                System.out.println(resultSet.getInt("ID"));
            }

            // 关闭结果集、Statement和连接
            resultSet.close();
            statement.close();
            conn.close();
            System.out.println("Oracle 连接成功，host=" + "10.92.87.140" + ",port=" + 1521);
        } catch (Exception e) {
            System.out.println("Oracle 连接失败，host=" + "10.92.87.140" + ",port=" + 1521);
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
