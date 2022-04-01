package com.edu.nbu.cn.datatransfer.core.executor;

import com.alibaba.fastjson.JSON;
import com.edu.nbu.cn.datatransfer.core.source.DefaultStageResult;
import com.edu.nbu.cn.datatransfer.core.source.JARStageResource;
import com.edu.nbu.cn.datatransfer.core.source.StageResource;
import com.edu.nbu.cn.datatransfer.core.source.StageResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.Jar;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.jar.Attributes;
import java.util.jar.JarInputStream;
import java.util.jar.Manifest;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/31-4:23 PM
 * @since 1.0
 */
@Component
@Slf4j
public class JarFileExecutor extends AbstractExecutor<String> implements InitializingBean {

    private static final String MAIN_CLASS_ATTR_NAME = "Main-Class";

    @Autowired
    private ExecutorSupport executorSupport;

    @Override
    public void execute(StageResource stageResource, StageResult stageResult) {
        super.execute(stageResource,null);
        commonExecute(stageResource);
    }

    @Override
    public StageResult<String> executeWithReturn(StageResource stageResource, StageResult stageResult) {
        super.executeWithReturn(stageResource, stageResult);
        return commonExecute(stageResource);
    }

    @Override
    public String name() {
        return InternalExecutorType.JAR_FILE_EXECUTOR.getName();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("register to executorRegistry,executor[" + this.name() + "]");
        executorSupport.registerExecutor(this);
    }

    private  DefaultStageResult commonExecute(StageResource stageResource){
        if(!(stageResource instanceof JARStageResource)){
            log.warn("stageResource is [" + stageResource.sourceType() + "]but not a JARStageResource!");
            throw new IllegalArgumentException("illegal source type [" + stageResource.sourceType() + "]");
        }
        String absoluteFilePath = ((JARStageResource) stageResource).getOriginalFileName();
        try {
            File jarFile = new File(absoluteFilePath);
            JarInputStream jarInputStream =  new JarInputStream(new FileInputStream(jarFile));
            Manifest mf = jarInputStream.getManifest();
            Attributes mainClassAttr = mf.getMainAttributes();
            String mainClassName = mainClassAttr.getValue(MAIN_CLASS_ATTR_NAME);

            String filePathWithProtocol = "file:" + absoluteFilePath;
            URLClassLoader classLoader = new URLClassLoader(new URL[]{new URL(filePathWithProtocol)});
            Class<?> mainClass = classLoader.loadClass(mainClassName);
            Method mainMethod = mainClass.getMethod("main",String[].class);
            mainMethod.invoke(null,(Object) new String[]{});
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return DefaultStageResult.of("success!");
    }
}
