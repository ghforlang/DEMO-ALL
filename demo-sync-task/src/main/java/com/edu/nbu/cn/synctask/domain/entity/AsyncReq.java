package com.edu.nbu.cn.synctask.domain.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author laoshi . hua
 * @version 1.0 2023/11/27-4:58 PM
 * @since 1.0
 */
@Getter
@Setter
public class AsyncReq implements Serializable {
    /**
     * 主键ID
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
     * 全路径类名称
     */
    private String className;

    /**
     * method名称
     */
    private String methodName;

    /**
     * 异步策略类型
     */
    private String asyncPattern;

    /**
     * 执行状态 0：未处理 1：处理失败
     */
    private Integer execStatus;

    /**
     * 执行次数
     */
    private Integer execCount;

    /**
     * 参数json字符串
     */
    private String jsonParam;

    /**
     * 业务描述
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;
}
