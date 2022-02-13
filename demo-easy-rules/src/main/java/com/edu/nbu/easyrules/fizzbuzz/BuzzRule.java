package com.edu.nbu.easyrules.fizzbuzz;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Priority;
import org.jeasy.rules.annotation.Rule;

/**
 * @author laoshi . hua
 * @version 1.0 2022/2/13-10:53 上午
 * @since 1.0
 */
@Rule
public class BuzzRule {

    @Condition
    public boolean isBuzz(@Fact("number") Integer number){
        return number % 7 == 0;
    }

    @Action
    public void printBuzz(){
        System.out.println("buzz!");
    }

    @Priority
    public int gerPriority(){
        return 2;
    }

}
