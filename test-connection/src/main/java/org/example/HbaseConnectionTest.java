package org.example;

import com.alibaba.lindorm.client.core.utils.Bytes;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;

import java.io.IOException;

/**
 * @author laoshi . hua
 * @version 1.0 2024/5/28-14:48
 * @since 1.0
 */
public class HbaseConnectionTest {
    public static boolean isConnected() throws IOException {
        // 新建一个Configuration
        Configuration conf = HBaseConfiguration.create();
// 集群的连接地址（公网地址）在控制台页面的数据库连接界面获得
        conf.set("hbase.zookeeper.quorum", "10.92.4.159:30020");
// xml_template.comment.hbaseue.username_password.default
        conf.set("hbase.client.username", "hbaset");
        conf.set("hbase.client.password", "hbaset");

        Connection connection = ConnectionFactory.createConnection(conf);


        //Table为非线程安全对象，每个线程在对Table操作时，都必须从Connection中获取相应的Table对象
        try (Table table = connection.getTable(TableName.valueOf("hbase_test"))) {

            // 单行读取
            Get get = new Get(Bytes.toBytes("row"));
            Result res = table.get(get);

            // scan 范围数据
            Scan scan = new Scan(Bytes.toBytes("startRow"), Bytes.toBytes("endRow"));
            ResultScanner scanner = table.getScanner(scan);
            for (Result result : scanner) {
                System.out.println(result.toString());
            }
            scanner.close();
            System.out.println("hbase连接成功,host: " + "10.92.4.159" + "，端口：" + 30020);
            return true;
        }catch ( Exception e){
            System.out.println("hbase连接失败" + e.getMessage());
            return false;
        }
    }

}
