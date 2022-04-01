package com.edu.nbu.cn.datatransfer.core.source;

import com.edu.nbu.cn.datatransfer.exception.IllegalNameException;
import org.apache.commons.lang3.StringUtils;

import java.util.Locale;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/25-3:23 下午
 * @since 1.0
 */
public class JARStageResource extends AbstractStageResource {
    private static final  String suffix = ".jar";

    private Class<?> mainClass;

    private String originalFileName;

    public JARStageResource(String sourceName,String originalFileName) {
        super(sourceName);
        if(StringUtils.isBlank(sourceName) || !(sourceName.endsWith(suffix) || sourceName.endsWith(suffix.toUpperCase()))){
            throw new IllegalNameException("JARStageResource name illegal ,[" + sourceName + "]");
        }
        this.originalFileName = originalFileName;
    }


    @Override
    public String sourceType() {
        return InternalStageResourceType.JAR_FILE.getTypeName();
    }

    public Class<?> getMainClass() {
        return mainClass;
    }

    public void setMainClass(Class<?> mainClass) {
        this.mainClass = mainClass;
    }

    public String getOriginalFileName() {
        return originalFileName;
    }

    public void setOriginalFileName(String originalFileName) {
        this.originalFileName = originalFileName;
    }

}
