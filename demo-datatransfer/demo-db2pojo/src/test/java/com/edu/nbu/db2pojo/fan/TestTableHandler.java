package com.edu.nbu.db2pojo.fan;

import com.alibaba.fastjson.JSON;
import com.edu.nbu.fan.db2pojo.db.DBTableHandler;
import com.edu.nbu.fan.db2pojo.db.metadata.TableMetaDataInfo;
import com.edu.nbu.fan.db2pojo.generator.JavaCodeGenerator;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;

/**
 * @author laoshi . hua
 * @version 1.0 2022/4/2-6:00 PM
 * @since 1.0
 */
public class TestTableHandler extends BaseTest{
    @Autowired
    private DBTableHandler tableHandler;
    @Autowired
    private JavaCodeGenerator javaCodeGenerator;

    @Test
    public void testAllTableNames() throws SQLException {
        List<TableMetaDataInfo> columnMetaDataInfos = tableHandler.listTables();
        System.out.println(JSON.toJSONString(columnMetaDataInfos));
    }

    @Test
    public void testGenerateCode(){
        javaCodeGenerator.generator("success!");
    }
}
