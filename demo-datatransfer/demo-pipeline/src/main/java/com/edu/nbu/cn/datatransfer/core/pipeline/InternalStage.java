package com.edu.nbu.cn.datatransfer.core.pipeline;


/**
 * @author laoshi . hua
 * @version 1.0 2022/3/31-4:03 PM
 * @since 1.0
 */
public enum InternalStage {
    PREPARED("prepared"),
    DEFAULT("default"),
    CODE_GENERATOR("codeGenerate"),
    SQL_SCRIPT("sqlScript"),
    JAR_FILE("jarFile");

    InternalStage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private String name;


}
