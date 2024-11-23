package com.edu.nbu.cn.synctask.domain.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author laoshi . hua
 * @version 1.0 2023/11/27-4:59 PM
 * @since 1.0
 */
@Setter
@Getter
public class AsyncLog implements Serializable {

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 异步请求ID
     */
    private Long asyncId;

    /**
     * 执行错误信息
     */
    private String errorData;

    /**
     * 创建时间
     */
    private Date createTime;
}
