package com.edu.nbu.cn.synctask.application.helper;

import com.edu.nbu.cn.synctask.domain.entity.AsyncReq;
import com.edu.nbu.cn.synctask.model.ExecutionModel;
import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 * @author laoshi . hua
 * @version 1.0 2023/11/27-5:26 PM
 * @since 1.0
 */
@Component
public class AsyncBeanHelper {
    public Function<AsyncReq, ExecutionModel> toAsyncExecDto = (asyncReq) -> {
        if (null == asyncReq) {
            return null;
        }
        ExecutionModel executionModel = new ExecutionModel();
        executionModel.setId(asyncReq.getId());
        executionModel.setApplication(asyncReq.getApplication());
        executionModel.setMethodSignature(asyncReq.getMethodSignature());
        executionModel.setClassName(asyncReq.getClassName());
        executionModel.setMethodName(asyncReq.getMethodName());
        executionModel.setAsyncPattern(asyncReq.getAsyncPattern());
        executionModel.setJsonParam(asyncReq.getJsonParam());
        executionModel.setRemark(asyncReq.getRemark());
        return executionModel;
    };


    public Function<ExecutionModel, AsyncReq> toAsyncReq = (executionModel) -> {
        if (null == executionModel) {
            return null;
        }
        AsyncReq asyncReq = new AsyncReq();
        asyncReq.setApplication(executionModel.getApplication());
        asyncReq.setMethodSignature(executionModel.getMethodSignature());
        asyncReq.setClassName(executionModel.getClassName());
        asyncReq.setMethodName(executionModel.getMethodName());
        asyncReq.setAsyncPattern(executionModel.getAsyncPattern());
        asyncReq.setJsonParam(executionModel.getJsonParam());
        asyncReq.setRemark(executionModel.getRemark());
        return asyncReq;
    };

}
