package com.edu.nbu.logger.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author laoshi . hua
 * @version 1.0 2022/8/22-2:53 PM
 * @since 1.0
 */
@RestController
@RequestMapping("/logger/demo")
@Slf4j
public class LoggerDemoController {

    private static final Marker marker = MarkerFactory.getMarker("【测试测试】");

    @GetMapping("/v1")
    public String v1(){
        log.info(marker,"this is v1!");
        return "v1";
    }
}
