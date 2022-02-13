package com.edu.nbu.easyrules.fizzbuzz;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Priority;
import org.jeasy.rules.annotation.Rule;

/**
 * @author laoshi . hua
 * @version 1.0 2022/2/13-10:51 上午
 * @since 1.0
 */
@Rule
public class FizzRule {

    @Condition
    public boolean isFizz(@Fact("number") Integer number){
       return number % 5 == 0 ;
    }

    @Action
    public void printFizz(){
        System.out.println("fizz!");
    }

    @Priority
    public int getPriority(){
        return 1;
    }
}
