package com.edu.nbu.easyrules.weather;

import org.jeasy.rules.api.Fact;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;

/**
 * @author laoshi . hua
 * @version 1.0 2022/2/18-5:39 下午
 * @since 1.0
 */
public class Launcher {
    public static void main(String[] args) {
        Fact fact = new Fact("rain",true);
        Facts facts = new Facts();
        facts.put("rain",fact);

        WeatherRule rule = new WeatherRule();
        Rules rules = new Rules();
        rules.register(rule);

        RulesEngine engine = new DefaultRulesEngine();
        engine.fire(rules,facts);
    }
}
