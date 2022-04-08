package com.edu.nbu.cn.datatransfer.core.source;

import com.edu.nbu.cn.datatransfer.core.source.scripts.SQLScript;
import com.edu.nbu.cn.datatransfer.exception.IllegalNameException;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/25-3:30 下午
 * @since 1.0
 */
public class SQLScriptStageResource extends ScriptStageResource {
    private static final  String file_suffix = ".sql";

    private String sourceName;
    public SQLScriptStageResource(String sourceName, SQLScript...scripts) {
        super(scripts);
        this.sourceName = sourceName;
        if(StringUtils.isBlank(sourceName)){
            throw new IllegalNameException("illegal Resource name [" + sourceName + "]");
        }
        if(ArrayUtils.isEmpty(scripts)){
            throw new IllegalArgumentException("illegal can not be null or empty !");
        }
        for(SQLScript script : scripts){
            if(!script.filePath().endsWith(file_suffix)){
                throw new IllegalNameException("illegal sql file name [" + script + "]");
            }
        }
    }


    @Override
    public String sourceName() {
        return sourceName;
    }

    @Override
    public boolean hasResult() {
        return false;
    }

    @Override
    public String sourceType() {
        return InternalStageResourceType.SQL_SCRIPT.getTypeName();
    }
}
