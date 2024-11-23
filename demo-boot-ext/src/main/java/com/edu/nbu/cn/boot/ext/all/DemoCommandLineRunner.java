package com.edu.nbu.cn.boot.ext.all;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author laoshi . hua
 * @version 1.0 2023/8/24-10:28 AM
 * @since 1.0
 */
@Component
@Slf4j
public class DemoCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        log.info(this.getClass().getName() + "#run()" + " is executing  in order " + 18);
    }
}
