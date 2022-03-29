package com.edu.nbu.fan.spel;

import com.edu.nbu.fan.spel.bean.TestBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.AccessException;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.ParserContext;
import org.springframework.expression.PropertyAccessor;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.ReflectivePropertyAccessor;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/28-6:57 下午
 * @since 1.0
 */

public class SPELApplication {
    private static final SPELApplication application = new SPELApplication();

    public static void main(String[] args) throws AccessException {
        application.testBeanName();
//        application.testSpringContainer();
//        application.testStandardContainer();
    }

    public void testBeanName(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring-bean.xml");
        TestBean tb = (TestBean) ctx.getBean("test");
        System.out.println(tb.getName());
        System.out.println(tb.getB1().getName());
        System.out.println(tb.getB1Name());
        System.out.println(tb.getGetB1Name());
        System.out.println(tb.isLongerThan3());
        System.out.println(tb.isNumBool());
    }

    // default
    public void testSpringContainer(){
        String str = " 1 + 2";
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression(str);
        System.out.println("testSpringContainer : "  + expression.getValue());
    }


    public void testStandardContainer() throws AccessException {
//        List<Integer> primes = new ArrayList<Integer>();
//        primes.addAll(Arrays.asList(2,3,5,7,11,13,17));
//        ExpressionParser parser = new SpelExpressionParser();
//        StandardEvaluationContext context = new StandardEvaluationContext();
//        context.setVariable("primes",primes);
//        List<Integer> primesGreaterThanTen = (List<Integer>) parser.parseExpression("#primes.?[#this>10]").getValue(context);
//        primesGreaterThanTen.forEach(v -> System.out.println(v));

        // 参考文章 :https://blog.51cto.com/u_3631118/3121519
        String str = " 1 + 2";
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression(str);
        StandardEvaluationContext context = new StandardEvaluationContext();
        System.out.println("testStandardContainer : "  + expression.getValue(context));

    }


}
