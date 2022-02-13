package com.edu.nbu.easyrules.helloworld;

import lombok.extern.slf4j.Slf4j;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Rule;

/**
 * @author laoshi . hua
 * @version 1.0 2022/2/10-2:17 下午
 * @since 1.0
 */
@Rule(name="hello world rule",description = "always say hello world")
@Slf4j
public class HelloWorldRule {

    @Condition
    public boolean when(){
        return true;
    }

    @Action
    public void then(){
//        log.info("hello world!");
        System.out.println("hello world!");
    }
}
