package com.edu.nbu.fan.spel.bean;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/28-7:01 下午
 * @since 1.0
 */

public class TestBean {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Value("${customName}")
    private String name;

    public TestBean(String name) {
        this.name = name;
    }


}
