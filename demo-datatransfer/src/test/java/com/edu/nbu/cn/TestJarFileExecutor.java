package com.edu.nbu.cn;

import com.edu.nbu.cn.datatransfer.core.executor.ExecutorSupport;
import com.edu.nbu.cn.datatransfer.core.executor.InternalExecutorType;
import com.edu.nbu.cn.datatransfer.core.source.DefaultStageResult;
import com.edu.nbu.cn.datatransfer.core.source.JARStageResource;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author laoshi . hua
 * @version 1.0 2022/4/1-10:28 AM
 * @since 1.0
 */
public class TestJarFileExecutor extends BaseTest{

    @Autowired
    private ExecutorSupport executorSupport;

    private String absoluteFilePath;


    private static final String jarFileName = "demo-spel-1.0-SNAPSHOT.jar";
    @Before
    public void init(){
        absoluteFilePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    }


    @Test
    public void testJarFileExecutor(){
        JARStageResource stageResource = new JARStageResource(jarFileName,absoluteFilePath + jarFileName);
//        stageResource.setMainClass();
        executorSupport.getExecutor(InternalExecutorType.JAR_FILE_EXECUTOR.getName()).execute(stageResource, DefaultStageResult.of("success!"));
    }
}
