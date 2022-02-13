package com.edu.nbu.easyrules.fizzbuzz;

import org.jeasy.rules.annotation.Priority;
import org.jeasy.rules.support.composite.UnitRuleGroup;

/**
 * @author laoshi . hua
 * @version 1.0 2022/2/13-10:58 上午
 * @since 1.0
 */
public class FizzBuzzRule extends UnitRuleGroup {

    public FizzBuzzRule(Object ... rules){
        for(Object rule : rules){
            addRule(rule);
        }
    }

    @Override
    public int getPriority(){
        return 0;
    }
}
