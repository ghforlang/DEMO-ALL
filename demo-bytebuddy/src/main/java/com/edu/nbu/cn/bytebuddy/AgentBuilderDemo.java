package com.edu.nbu.cn.bytebuddy;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaModule;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.instrument.Instrumentation;

import static net.bytebuddy.matcher.ElementMatchers.named;

/**
 * @author laoshi . hua
 * @version 1.0 2023/7/28-3:03 PM
 * @since 1.0
 */
public class AgentBuilderDemo {

    public static void main(String[] args) {

    }

    public static void preMain(String args, Instrumentation instrumentation){
        new AgentBuilder.Default()
                .type(ElementMatchers.isAnnotatedWith(ToString.class))
                .transform(new AgentBuilder.Transformer(){
                    @Override
                    public DynamicType.Builder<?> transform(DynamicType.Builder<?> builder, TypeDescription typeDescription, ClassLoader classLoader, JavaModule module) {
                        return builder.method(named("toString")).intercept(FixedValue.value("fuck off!"));
                    }
                }).installOn(instrumentation);
    }

    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE})
    public @interface ToString{

    }
}
