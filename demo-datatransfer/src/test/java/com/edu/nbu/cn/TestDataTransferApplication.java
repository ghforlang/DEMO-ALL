package com.edu.nbu.cn;

import com.alibaba.fastjson.JSON;
import com.edu.nbu.cn.datatransfer.DataTransferApplication;
import com.edu.nbu.cn.datatransfer.db.DBTableHandler;
import com.edu.nbu.cn.datatransfer.db.metadata.TableMetaDataInfo;
import com.edu.nbu.cn.datatransfer.generator.JavaCodeGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;
import java.util.List;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/18-4:26 下午
 * @since 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DataTransferApplication.class)
public class TestDataTransferApplication {

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
