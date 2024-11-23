package com.edu.nbu.cn.boot.ext.scope;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author laoshi . hua
 * @version 1.0 2023/2/9-2:54 PM
 * @since 1.0
 */
@Service
@Scope("threadLocalScope")
@Slf4j
public class DemoScopeService {

    @Resource
    private ScopeApplicationUtils scopeApplicationUtils;

    public void scopeService(){
        log.info("scopeService demo!");
        DemoScopeService bean1 = scopeApplicationUtils.getBean(DemoScopeService.class);
        log.info("first bean:{}",bean1.toString());
        new Thread(() -> {
            DemoScopeService bean2 = scopeApplicationUtils.getBean(DemoScopeService.class);
            log.info("second bean:{}", bean2.toString());
        }).start();
        DemoScopeService bean3 = scopeApplicationUtils.getBean(DemoScopeService.class);
        log.info("third bean:{}", bean3.toString());
    }
}
