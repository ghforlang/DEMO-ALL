package com.edu.nbu.cn.datatransfer.core.source;

import com.edu.nbu.cn.datatransfer.exception.IllegalNameException;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/25-3:30 下午
 * @since 1.0
 */
public class SQLScriptStageResource extends ScriptStageResource {
    private static final  String file_suffix = ".sql";


    private String originalSqlFileName;

    public SQLScriptStageResource(String sourceName) {
        super(sourceName);
        if(!sourceName.endsWith(file_suffix)){
            throw new IllegalNameException("illegal sql file name [" + sourceName + "]");
        }
    }

    public SQLScriptStageResource(String sourceName, String originalSqlFileName) {
        super(sourceName);
        if(!sourceName.endsWith(file_suffix)){
            throw new IllegalNameException("illegal sql file name [" + sourceName + "]");
        }
        this.originalSqlFileName = originalSqlFileName;
    }

    public String getOriginalSqlFileName() {
        return originalSqlFileName;
    }



    @Override
    public String sourceName() {
        return sourceName;
    }

    @Override
    public String sourceType() {
        return InternalStageResourceType.SQL_SCRIPT.getTypeName();
    }
}
