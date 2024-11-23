package com.edu.nbu.cn.synctask.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author laoshi . hua
 * @version 1.0 2023/11/27-4:52 PM
 * @since 1.0
 */
@Getter
@Setter
public class PageModel<T> implements Serializable {

    /**
     * 页码
     */
    private int pageNum;

    /**
     * 每页展示数量
     */
    private int pageSize;

    /**
     * 总记录数
     */
    private long total;

    /**
     * 数据
     */
    private List<T> list;
}
