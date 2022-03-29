package com.edu.nbu.fan.spel.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/28-7:01 下午
 * @since 1.0
 */
@Getter
@Setter
public class TestBean {

    @Value("#{b1}")
    private Bean b1;
    @Value("#{b1.name}")
    private String b1Name;
    @Value("#{b1.getName()}")
    private String getB1Name;
    @Value("#{longerThan3")
    private boolean longerThan3;
    @Value("#{numBool}")
    private boolean numBool;
    @Value("#{numStr}")
    private String numStr;

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
