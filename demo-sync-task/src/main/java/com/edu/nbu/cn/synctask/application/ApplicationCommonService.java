package com.edu.nbu.cn.synctask.application;

import com.edu.nbu.cn.synctask.domain.entity.AsyncReq;
import com.edu.nbu.cn.synctask.model.ExecutionModel;

/**
 * @author laoshi . hua
 * @version 1.0 2023/11/27-5:16 PM
 * @since 1.0
 */
public interface ApplicationCommonService {

    /**
     * 执行方法
     *
     * @param asyncReq
     * @return
     */
    boolean invoke(AsyncReq asyncReq);

    /**
     * 执行方法
     *
     * @param executionInfo
     * @return
     */
    boolean invoke(ExecutionModel executionInfo);
}
