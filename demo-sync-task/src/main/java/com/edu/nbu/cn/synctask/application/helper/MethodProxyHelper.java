package com.edu.nbu.cn.synctask.application.helper;

import com.edu.nbu.cn.synctask.model.MethodProxy;
import com.edu.nbu.cn.synctask.utils.MD5Util;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author laoshi . hua
 * @version 1.0 2023/11/27-5:30 PM
 * @since 1.0
 */
@Component
public class MethodProxyHelper {
    /**
     * 代理类方法
     */
    private static final Map<String, MethodProxy> PROXY_METHOD_MAP = new ConcurrentHashMap<>();

    /**
     * 设置代理方法
     *
     * @param key
     * @param methodProxy
     */
    public void setProxyMethod(String key, MethodProxy methodProxy) {
        this.PROXY_METHOD_MAP.put(key, methodProxy);
    }

    /**
     * 获取代理方法
     *
     * @param key
     * @return
     */
    public MethodProxy getMethodProxy(String key) {
        return this.PROXY_METHOD_MAP.get(key);
    }

    /**
     * 获取异步方法唯一标识
     *
     * @param bean
     * @param method
     * @return
     */
    public String getAsyncMethodKey(Object bean, Method method) {
        if (method.toString().contains(bean.getClass().getName())) {
            // 异步执行注解在当前类方法上面
            return MD5Util.md5(method.toString());
        } else {
            // 异步执行注解在基类方法上面
            return MD5Util.md5(bean.getClass().getSimpleName() + "#" + method);
        }
    }
}
