package com.edu.nbu.cn.boot.ext.startup.model;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author laoshi . hua
 * @version 1.0 2023/2/9-11:15 AM
 * @since 1.0
 */
@Component
@Slf4j
public class LoadDataService {

    public  void loadData(){
        log.info("data is loading....");
    }
}
