package com.edu.nbu.cn.synctask.domain.service;

import com.edu.nbu.cn.synctask.domain.entity.AsyncLog;

/**
 * @author laoshi . hua
 * @version 1.0 2023/11/27-4:55 PM
 * @since 1.0
 */
public interface AsyncLogService {

    /**
     * 保存
     *
     * @param asyncLog
     */
    void save(AsyncLog asyncLog);

    /**
     * 删除
     *
     * @param asyncId
     */
    void delete(Long asyncId);

    /**
     * 获取最后一次失败信息
     *
     * @param asyncId
     * @return
     */
    String getErrorData(Long asyncId);
}
