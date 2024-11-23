package com.edu.nbu.cn.synctask.domain.service;

import com.edu.nbu.cn.synctask.domain.entity.AsyncReq;
import com.edu.nbu.cn.synctask.model.PageModel;

import java.util.List;

/**
 * @author laoshi . hua
 * @version 1.0 2023/11/27-4:56 PM
 * @since 1.0
 */
public interface AsyncReqService {

    /**
     * 保存
     *
     * @param asyncReq
     */
    void save(AsyncReq asyncReq);

    /**
     * 更新状态
     *
     * @param id
     * @param execStatus
     */
    void updateStatus(Long id, Integer execStatus);

    /**
     * 删除
     *
     * @param id
     */
    void delete(Long id);

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    AsyncReq getById(Long id);

    /**
     * 自动重试
     *
     * @return
     */
    List<AsyncReq> listRetry();

    /**
     * 自动补偿
     *
     * @return
     */
    List<AsyncReq> listComp();

    /**
     * 人工执行
     *
     * @param pageInfo
     */
    void listAsyncPage(PageModel<AsyncReq> pageInfo);
}
