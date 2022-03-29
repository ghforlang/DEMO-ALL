package com.edu.nbu.fan.spel;

import com.alibaba.fastjson.JSON;
import com.edu.nbu.fan.spel.bean.TestBean;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.AccessException;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.ParserContext;
import org.springframework.expression.PropertyAccessor;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.ReflectivePropertyAccessor;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/28-6:57 下午
 * @since 1.0
 */

public class SPELApplication {
    private static final SPELApplication application = new SPELApplication();

    public static void main(String[] args) throws AccessException, NoSuchMethodException {
//        application.testBeanExpression();
        application.testCollection();
//        application.testMethod();
//        application.testBeanId();
//        application.testBeanName();
//        application.testSpringContainer();
//        application.testStandardContainer();
    }

    public void testBeanExpression(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext();
        ctx.refresh();
        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setBeanResolver(new BeanFactoryResolver(ctx));

        Properties result = parser.parseExpression("@systemProperties").getValue(context,Properties.class);
        System.out.println(JSON.toJSONString(result.get("java.runtime.name")));
    }

    public void testCollection(){
        EvaluationContext ctx = new StandardEvaluationContext();
        ExpressionParser parser = new SpelExpressionParser();
        ctx.setVariable("ss","x");

        Map<String,String> map = new HashMap<>();
        map.put("xx","xxx");
        map.put("xxs","sxl");
        map.put("sxx","xxxxx");
        ctx.setVariable("map",map);
//        System.out.println(JSON.toJSONString(parser.parseExpression("#{ss?:'othes'}").getValue(ctx)));
        System.out.println(JSON.toJSONString(parser.parseExpression("{1,2,3}").getValue(List.class)));
        System.out.println(parser.parseExpression("{1,2,3}[0]").getValue(Integer.class));
        System.out.println(parser.parseExpression("#map['xx']").getValue(ctx,String.class));
        // setValue
        parser.parseExpression("#map['xx']").setValue(ctx,"sss");
        System.out.println(parser.parseExpression("#map['xx']").getValue(ctx,String.class));

        // filter,生成新的map
        System.out.println(JSON.toJSONString(map));
        System.out.println(JSON.toJSONString(parser.parseExpression("#map.?[#this.getKey().startsWith('x')]").getValue(ctx,Map.class)));
        System.out.println(JSON.toJSONString(parser.parseExpression("#map.?[#this.getValue().startsWith('x')]").getValue(ctx,Map.class)));

        // list
        List<Integer> intList = Arrays.asList(1,3,5,7);
        ctx.setVariable("intList",intList);
        System.out.println(JSON.toJSONString(intList));
        System.out.println(JSON.toJSONString(parser.parseExpression("#intList.?[#this%2==1]").getValue(ctx,List.class)));
        // 过滤，处理后生成新的list
        System.out.println(JSON.toJSONString(parser.parseExpression("#intList.?[#this%2==1].![#this + 1]").getValue(ctx,List.class)));

    }

    public void testOthers(){
        StandardEvaluationContext ctx = new StandardEvaluationContext();
        ExpressionParser parser = new SpelExpressionParser();
        //三目运算符缩写 (name !=null) ? name : "other"
    }

    public void testMethod() throws NoSuchMethodException {
        Method method = Integer.class.getMethod("parseInt", String.class);
        StandardEvaluationContext ctx = new StandardEvaluationContext();
        // 注册自定义函数
        ctx.registerFunction(method.getName(),method);
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("12");
        System.out.println(expression.getValue(ctx));
    }
    public void testBeanId(){
        StandardEvaluationContext ctx = new StandardEvaluationContext();
        ExpressionParser parser = new SpelExpressionParser();
        String result = parser.parseExpression("#root").getValue(ctx,String.class);
        ctx.setVariable("s","xxlxxxl");
        System.out.println(parser.parseExpression("#s.substring(0,1)").getValue(ctx,String.class));
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
        System.out.println(tb.getPI());
        System.out.println(tb.getElvis());
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
