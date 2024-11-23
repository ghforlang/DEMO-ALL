package com.edu.nbu.cn.boot.ext.all;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.stereotype.Component;

/**
 * @author laoshi . hua
 * @version 1.0 2023/8/24-10:26 AM
 * @since 1.0
 */
@Component
@Slf4j
public class DemoSmartInitializingSingleton  implements SmartInitializingSingleton {

    @Override
    public void afterSingletonsInstantiated() {
        log.info(this.getClass().getName() + "#afterSingletonsInstantiated()" + " is executing  in order " + 17);
    }
}
