package com.edu.nbu.cn;

import com.edu.nbu.cn.datatransfer.core.executor.ExecutorRegistry;
import com.edu.nbu.cn.datatransfer.core.executor.InternalExecutorType;
import com.edu.nbu.cn.datatransfer.core.source.DefaultStageResult;
import com.edu.nbu.cn.datatransfer.core.source.JARStageResource;
import org.junit.Before;
import org.junit.Test;

/**
 * @author laoshi . hua
 * @version 1.0 2022/4/1-10:28 AM
 * @since 1.0
 */
public class TestJarFileExecutor extends BaseTest{


    private String absoluteFilePath;


    private static final String jarFileName = "demo-spel-1.0-SNAPSHOT.jar";
    @Before
    public void init(){
        absoluteFilePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    }


    @Test
    public void testJarFileExecutor(){
        JARStageResource stageResource = new JARStageResource(jarFileName,absoluteFilePath + jarFileName);
        ExecutorRegistry.getExecutor(InternalExecutorType.JAR_FILE_EXECUTOR.getName()).execute(stageResource, DefaultStageResult.of("success!"));
    }
}
