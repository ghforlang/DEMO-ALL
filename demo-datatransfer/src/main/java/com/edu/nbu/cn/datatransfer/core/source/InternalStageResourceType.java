package com.edu.nbu.cn.datatransfer.core.source;

/**
 * @author laoshi . hua
 * @version 1.0 2022/4/1-10:56 AM
 * @since 1.0
 */
public enum InternalStageResourceType {
    DEFAULT("default"),SQL_SCRIPT("sqlScript"),JAR_FILE("jarFile");

    InternalStageResourceType(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    private String typeName;


}
