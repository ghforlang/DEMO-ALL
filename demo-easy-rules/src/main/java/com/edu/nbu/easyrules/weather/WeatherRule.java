package com.edu.nbu.easyrules.weather;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

/**
 * @author laoshi . hua
 * @version 1.0 2022/2/18-3:28 下午
 * @since 1.0
 */
@Rule(name = "weather rule",description = "rule of weather")
public class WeatherRule {

    @Condition
    public boolean rain(@Fact(value="rain")  boolean rain){
        return rain;
    }

    @Action
    public void action(){
        System.out.println("It rains, take an umbrella!");
    }
}
