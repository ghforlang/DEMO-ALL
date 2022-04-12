package com.edu.nbu.db2pojo.gen;

import com.alibaba.fastjson.JSON;
import com.edu.nbu.fan.gen.db.DBTableHandler;
import com.edu.nbu.fan.gen.db.metadata.TableMetaDataInfo;
import com.edu.nbu.fan.gen.generator.JavaCodeGenerator;
import com.edu.nbu.fan.gen.generator.SqlScriptGenerator;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;

/**
 * @author laoshi . hua
 * @version 1.0 2022/4/2-6:00 PM
 * @since 1.0
 */
public class TestGenerator extends BaseTest{
    @Autowired
    private DBTableHandler tableHandler;
    @Autowired
    private JavaCodeGenerator javaCodeGenerator;
    @Autowired
    private SqlScriptGenerator sqlScriptGenerator;

    @Test
    public void testAllTableNames() throws SQLException {
        List<TableMetaDataInfo> columnMetaDataInfos = tableHandler.listTables();
        System.out.println(JSON.toJSONString(columnMetaDataInfos));
    }

    @Test
    public void testGenerateCode(){
        javaCodeGenerator.generator("success!");
    }

    @Test
    public void testGenerateSQLScript(){
        sqlScriptGenerator.generate("success!");
    }
}
