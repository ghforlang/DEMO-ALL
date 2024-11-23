package com.edu.nbu.cn.boot.ext.startup;

import com.edu.nbu.cn.boot.ext.startup.model.LoadDataService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author laoshi . hua
 * @version 1.0 2023/2/9-11:14 AM
 * @since 1.0
 */
@Component
@Order(Integer.MIN_VALUE)
public class ThenRunner implements ApplicationRunner {

    @Resource
    private LoadDataService loadDataService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        loadDataService.loadData();
    }
}
