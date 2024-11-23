package com.edu.nbu.cn.synctask.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author laoshi . hua
 * @version 1.0 2023/11/27-4:48 PM
 * @since 1.0
 */
@Getter
@Setter
public class ExecutionModel implements Serializable {
    /**
     * 自增id
     */
    private Long id;

    /**
     * 应用名称
     */
    private String application;

    /**
     * 方法签名
     */
    private String methodSignature;

    /**
     * 全路径类名
     */
    private String className;

    /**
     * 方法名名称
     */
    private String methodName;

    /**
     * 异步任务模式
     */
    private String asyncPattern;

    /**
     * json参数
     */
    private String jsonParam;

    /**
     * 任务描述
     */
    private String remark;
}
