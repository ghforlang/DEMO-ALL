package com.edu.nbu.cn;

import com.alibaba.fastjson.JSON;
import com.edu.nbu.cn.datatransfer.DataTransferApplication;
import com.edu.nbu.cn.datatransfer.core.executor.CodeGeneratorExecutor;
import com.edu.nbu.cn.datatransfer.core.executor.DefaultExecutor;
import com.edu.nbu.cn.datatransfer.core.pipeline.DefaultPipeline;
import com.edu.nbu.cn.datatransfer.core.pipeline.DefaultStage;
import com.edu.nbu.cn.datatransfer.core.pipeline.Pipeline;
import com.edu.nbu.cn.datatransfer.core.pipeline.Stage;
import com.edu.nbu.cn.datatransfer.core.source.DefaultStageResult;
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
    @Autowired
    private Pipeline defaultPipeline;
    @Autowired
    private CodeGeneratorExecutor codeGeneratorExecutor;

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
    public void testPipeline(){

        DefaultStage stage = new DefaultStage.Builder("codeGenerator")
                .sourceName("codeGenerator")
                .executor(codeGeneratorExecutor)
                .order(1)
                .stageResult(DefaultStageResult.of("success"))
                .usePreviousResult(false)
                .build();

        DefaultStage stage1 = new DefaultStage.Builder("test")
                .sourceName("test.sql")
                .executor(new DefaultExecutor())
                .order(112)
                .stageResult(DefaultStageResult.of("Success"))
                .usePreviousResult(false)
                .build();

        DefaultStage stage2 = new DefaultStage.Builder("ttt")
                .sourceName("ttt.sql")
                .executor(new DefaultExecutor())
                .order(10)
                .stageResult(DefaultStageResult.of("Success"))
                .usePreviousResult(false)
                .build();
        // 装配stages
        defaultPipeline.plugin(new Stage[]{stage,stage1,stage2});
        // 执行stages
        defaultPipeline.execute();
    }
}
