package com.edu.nbu.easyrules.fizzbuzz;

import com.sun.deploy.security.ruleset.DefaultRule;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.api.RulesEngineParameters;
import org.jeasy.rules.core.DefaultRulesEngine;

/**
 * @author laoshi . hua
 * @version 1.0 2022/2/13-11:16 上午
 * @since 1.0
 */
public class FizzBuzzMain {

    public static void main(String[] args) {
        RulesEngineParameters parameters = new RulesEngineParameters().skipOnFirstAppliedRule(true);
        RulesEngine rulesEngine = new DefaultRulesEngine(parameters);

        Rules rules = new Rules();
        rules.register(new FizzRule());
        rules.register(new BuzzRule());
        rules.register(new FizzBuzzRule());
        rules.register(new NonFizzBuzzRule());

        Facts facts = new Facts();
        for (int i=0;i<100;i++){
            facts.put("number",i);
            rulesEngine.fire(rules,facts);
            System.out.println();
        }
    }
}
