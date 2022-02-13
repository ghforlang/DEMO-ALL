package com.edu.nbu.easyrules.fizzbuzz;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Priority;
import org.jeasy.rules.annotation.Rule;

/**
 * @author laoshi . hua
 * @version 1.0 2022/2/13-11:10 上午
 * @since 1.0
 */
@Rule
public class NonFizzBuzzRule {

    @Condition
    public boolean isNotFizzBuzz(@Fact("number") Integer number){
        return number % 5 != 0 || number % 7 != 0;
    }

    @Action
    public void printInput(@Fact("number") Integer number){
        System.out.println(number);
    }

    @Priority
    public int getPriority(){
        return 3;
    }
}
