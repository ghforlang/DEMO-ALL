package com.edu.nbu.easyrules.helloworld;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;

/**
 * @author laoshi . hua
 * @version 1.0 2022/2/10-2:31 下午
 * @since 1.0
 */
public class HelloWorldLauncher {

    public static void main(String[] args) {
        Facts facts = new Facts();

        Rules rules = new Rules();
        rules.register(new HelloWorldRule());

        RulesEngine rulesEngine = new DefaultRulesEngine();
        rulesEngine.fire(rules,facts);
    }
}
