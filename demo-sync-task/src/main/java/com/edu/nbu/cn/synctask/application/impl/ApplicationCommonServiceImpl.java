package com.edu.nbu.cn.synctask.application.impl;

import com.edu.nbu.cn.synctask.application.ApplicationCommonService;
import com.edu.nbu.cn.synctask.application.helper.AsyncBeanHelper;
import com.edu.nbu.cn.synctask.application.helper.MethodProxyHelper;
import com.edu.nbu.cn.synctask.constants.AsyncConstants;
import com.edu.nbu.cn.synctask.constants.enums.AsyncPatternEnum;
import com.edu.nbu.cn.synctask.constants.enums.ExecuteStatusEnum;
import com.edu.nbu.cn.synctask.domain.entity.AsyncLog;
import com.edu.nbu.cn.synctask.domain.entity.AsyncReq;
import com.edu.nbu.cn.synctask.domain.service.AsyncLogService;
import com.edu.nbu.cn.synctask.domain.service.AsyncReqService;
import com.edu.nbu.cn.synctask.model.ExecutionModel;
import com.edu.nbu.cn.synctask.model.MethodProxy;
import com.edu.nbu.cn.synctask.utils.JacksonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * @author laoshi . hua
 * @version 1.0 2023/11/27-5:17 PM
 * @since 1.0
 */

@Component
@Slf4j
public class ApplicationCommonServiceImpl implements ApplicationCommonService {

    @Autowired
    private AsyncReqService asyncReqService;

    @Autowired
    private AsyncLogService asyncLogService;

    @Resource
    private AsyncBeanHelper asyncBeanHelper;

    @Autowired
    private MethodProxyHelper methodProxyHelper;

    /**
     * 执行成功是否删除：默认是
     */
    @Value("${async.exec.deleted:true}")
    private boolean deleted;

    /**
     * 最大重试执行次数：默认5次
     */
    @Value("${async.exec.count:5}")
    private int execCount;

    @Override
    public boolean invoke(AsyncReq asyncReq) {
        return this.invoke(asyncBeanHelper.toAsyncExecDto.apply(asyncReq));
    }

    @Override
    public boolean invoke(ExecutionModel executionInfo) {
        if (null == executionInfo) {
            return true;
        }
        // 标记
        AsyncConstants.PUBLISH_EVENT.set(Boolean.TRUE);
        // 获取执行的类和方法
        MethodProxy methodProxy = methodProxyHelper.getMethodProxy(executionInfo.getMethodSignature());
        if (null == methodProxy) {
            log.warn("异步执行代理类方法不存在：{}", executionInfo);
            return true;
        }

        if (null == executionInfo.getId()) {
            // 直接执行
            return this.execute(methodProxy, executionInfo);
        } else {
            // 补偿执行
            return this.recoupExecute(methodProxy, executionInfo);
        }
    }


    /**
     * 直接执行
     *
     * @param methodProxy
     * @param executionModel
     * @return
     */
    private boolean execute(MethodProxy methodProxy, ExecutionModel executionModel) {
        try {
            // 执行异步方法
            this.invokeMethod(methodProxy, executionModel);
            return true;
        } catch (Exception e) {
            if (AsyncPatternEnum.ASYNC.name().equals(executionModel.getAsyncPattern()) || AsyncPatternEnum.THREAD.name().equals(executionModel.getAsyncPattern())) {
                // 异步消息和异步线程 执行失败 不保存数据库
                log.error("【{}】执行失败：{}", AsyncPatternEnum.getByPattern(executionModel.getAsyncPattern()).getDesc(), executionModel, e);
            } else {
                // 保存异步执行请求
                this.saveAsyncReq(executionModel);
            }
            return false;
        }
    }

    /**
     * 补偿执行
     *
     * @param methodProxy
     * @param executionModel
     * @return
     */
    private boolean recoupExecute(MethodProxy methodProxy, ExecutionModel executionModel) {
        AsyncReq asyncReq = asyncReqService.getById(executionModel.getId());
        if (null == asyncReq) {
            return true;
        }
        try {
            // 执行异步方法
            this.invokeMethod(methodProxy, executionModel);
            // 更新执行结果
            this.updateAsyncReq(asyncReq);
            return true;
        } catch (Exception e) {
            if (asyncReq.getExecCount() + 1 >= execCount) {
                log.error("异步执行方法失败超过{}次：{}", execCount, executionModel, e);
            }
            // 执行失败更新执行次数且记录失败日志
            this.saveAsyncLog(asyncReq, e);
            return false;
        }
    }

    /**
     * 反射执行异步方法
     *
     * @param methodProxy
     * @param executionModel
     */
    private void invokeMethod(MethodProxy methodProxy, ExecutionModel executionModel) {
        log.info("异步执行方法开始：{}", executionModel);
        // 获取参数类型
        Object[] paramTypes = this.getParamType(methodProxy.getMethod(), executionModel.getJsonParam());
        // 执行方法
        ReflectionUtils.invokeMethod(methodProxy.getMethod(), methodProxy.getBeanObject(), paramTypes);
        log.info("异步执行方法成功：{}", executionModel);
    }

    /**
     * 获取方法参数
     *
     * @param method
     * @param data
     * @return
     */
    private Object[] getParamType(Method method, String data) {
        Type[] types = method.getGenericParameterTypes();
        if (types.length == 0) {
            return null;
        }
        return JacksonUtil.toObjects(data, types);
    }

    /**
     * 保存异步执行请求
     *
     * @param executionModel
     */
    private void saveAsyncReq(ExecutionModel executionModel) {
        AsyncReq asyncReq = asyncBeanHelper.toAsyncReq.apply(executionModel);
        asyncReq.setExecStatus(ExecuteStatusEnum.ERROR.getStatus());
        asyncReqService.save(asyncReq);
        log.info("处理失败后保存数据库成功：{}", asyncReq);
    }

    /**
     * 执行失败更新执行次数且记录失败日志
     *
     * @param asyncReq
     * @param e
     */
    private void saveAsyncLog(AsyncReq asyncReq, Exception e) {
        // 更新状态为失败
        asyncReqService.updateStatus(asyncReq.getId(), ExecuteStatusEnum.ERROR.getStatus());
        // 保存执行失败日志
        AsyncLog asyncLog = new AsyncLog();
        asyncLog.setAsyncId(asyncReq.getId());
        asyncLog.setErrorData(ExceptionUtils.getStackTrace(e));
        asyncLogService.save(asyncLog);
        log.info("处理失败后保存失败日志成功：{}", asyncReq);
    }

    /**
     * 更新异步执行请求
     *
     * @param asyncReq
     */
    private void updateAsyncReq(AsyncReq asyncReq) {
        if (deleted) {
            // 删除异步执行请求
            asyncReqService.delete(asyncReq.getId());
        } else {
            // 更新状态为成功
            asyncReqService.updateStatus(asyncReq.getId(), ExecuteStatusEnum.SUCCESS.getStatus());
        }
        if (asyncReq.getExecStatus() == ExecuteStatusEnum.ERROR.getStatus()) {
            // 删除异步执行日志
            asyncLogService.delete(asyncReq.getId());
        }
    }
}
