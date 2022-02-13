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
    private static final String yamlFilePath = "/Users/fanwenhao/my-projects/DEMO-ALL/demo-easy-rules/target/classes/alcohol-rule.yml";

    public static void main(String[] args) throws Exception {
        Person tom = new Person("tom",12);
        Facts facts = new Facts();
        facts.put("person",tom);

        Rule ageRule = new MVELRule()
                .name("ageRule")
                .description("check if person's age is > 18 and marks the person as adult!")
                .priority(1)
                .when("person.age > 18")
                .then("person.setAdult(true)");


        YamlRuleDefinitionReader yamlRuleDefinitionReader = new YamlRuleDefinitionReader(new Yaml());
        MVELRuleFactory mvelRuleFactory = new MVELRuleFactory(yamlRuleDefinitionReader);
        Rule alcoholRule = mvelRuleFactory.createRule(new FileReader(yamlFilePath));
        Rules rules = new Rules();
        rules.register(ageRule);
        rules.register(alcoholRule);

        RulesEngine rulesEngine = new DefaultRulesEngine();
        System.out.println("Tom: Hi! can I have some Vodka please?");
        rulesEngine.fire(rules,facts);
    }
}
