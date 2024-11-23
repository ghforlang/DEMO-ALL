package com.edu.nbu.cn.synctask.constants.enums;

import lombok.Getter;

/**
 * @author laoshi . hua
 * @version 1.0 2023/11/27-4:44 PM
 * @since 1.0
 */
@Getter
public enum ExecuteStatusEnum {


    /**
     * 初始化
     */
    INIT(0, "初始化"),

    /**
     * 执行失败
     */
    ERROR(1, "执行失败"),

    /**
     * 执行成功
     */
    SUCCESS(2, "执行成功");

    /**
     * 类型
     */
    private final int status;

    /**
     * 名称
     */
    private final String name;

    ExecuteStatusEnum(int status, String name) {
        this.status = status;
        this.name = name;
    }
}
