package com.edu.nbu.cn.datatransfer.core.executor;


/**
 * @author laoshi . hua
 * @version 1.0 2022/3/31-3:03 PM
 * @since 1.0
 */
public enum InternalExecutorType {
    DEFAULT_EXECUTOR("default"),
    CODE_GENERATOR_EXECUTOR("codeGenerator"),
    SQL_SCRIPT_EXECUTOR("sqlScript"),
    PREPARED_EXECUTOR("prepared"),
    JAR_FILE_EXECUTOR("jarFile")
    ;


    private String name;

    InternalExecutorType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }



}
