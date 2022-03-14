package com.edu.nbu.easyrules.shop;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.mvel.MVELRule;
import org.jeasy.rules.mvel.MVELRuleFactory;
import org.jeasy.rules.support.reader.YamlRuleDefinitionReader;
import org.yaml.snakeyaml.Yaml;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @author laoshi . hua
 * @version 1.0 2022/2/13-11:29 上午
 * @since 1.0
 */
public class ShopMain {
    private static final String yamlFilePath = "demo-easy-rules/src/main/java/com/edu/nbu/easyrules/shop/alcohol-rule.yml";

    public static void main(String[] args) throws Exception {
        Person tom = new Person("tom",12);
        Facts facts = new Facts();
        facts.put("person",tom);

        MVELRule ageRule = new MVELRule()
                .name("age rule")
                .description("Check if person's age is > 18 and mark the person as adult")
                .priority(1)
                .when("person.age > 18")
                .then("person.setAdult(true);");


        MVELRuleFactory mvelRuleFactory = new MVELRuleFactory(new YamlRuleDefinitionReader());
        Rule alcoholRule = mvelRuleFactory.createRule(new FileReader(yamlFilePath));


        Rules rules = new Rules();
        rules.register(ageRule);
        rules.register(alcoholRule);

        RulesEngine rulesEngine = new DefaultRulesEngine();
        System.out.println("Tom: Hi! can I have some Vodka please?");
        rulesEngine.fire(rules,facts);
    }
}
