package com.edu.nbu.cn.boot.ext.interceptor;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author laoshi . hua
 * @version 1.0 2023/2/1-10:20 AM
 * @since 1.0
 */
@Component
@Slf4j
public class CheckInterceptor extends HandlerInterceptorAdapter {

    private static final Map<String,Long> requestCountMap = new ConcurrentHashMap<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //权限、日志、统计类逻辑
        String requestUrl = request.getRequestURI();
        printLog(requestUrl);
        checkAuth(requestUrl,request.getParameterMap());
        countRequest(requestUrl,request.getParameterMap());
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    private boolean checkAuth(String requestUrl,Map<String,String[]> paramMap){
        log.info("拦截器权限校验,requestUrl:{}",requestUrl);
        return false;
    }

    private void printLog(String requestUrl){
        log.info("拦截器日志打印,requestUrl:{}",requestUrl);
    }

    private void countRequest(String requestUrl, Map<String,String[]> paramMap){
        long requestCount = requestCountMap.getOrDefault(requestUrl,0L);
        requestCount++;
        requestCountMap.put(requestUrl,requestCount);
        log.info("拦截器请求统计,requestUrl:{}",requestUrl);
    }
}
