package com.edu.nbu.cn.synctask.constants;

import lombok.experimental.UtilityClass;

/**
 * @author laoshi . hua
 * @version 1.0 2023/11/27-5:36 PM
 * @since 1.0
 */
@UtilityClass
public class AsyncConstants {

    /**
     * 执行代理方法防止死循环
     */
    public static final ThreadLocal<Boolean> PUBLISH_EVENT = ThreadLocal.withInitial(() -> false);

    /**
     * 成功
     */
    public static final int SUCCESS = 1;

    /**
     * 失败
     */
    public static final int ERROR = 0;

    /**
     * 登录
     */
    public static final int LOGIN = -1;

    /**
     * 队列后缀
     */
    public static final String QUEUE_SUFFIX = "_async_queue";
}
