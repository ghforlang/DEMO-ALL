package com.edu.nbu.cn.bytebuddy;

import com.edu.nbu.cn.bytebuddy.model.Bar;
import com.edu.nbu.cn.bytebuddy.model.Foo;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.implementation.MethodDelegation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static net.bytebuddy.matcher.ElementMatchers.named;

/**
 * @author laoshi . hua
 * @version 1.0 2023/7/27-2:54 PM
 * @since 1.0
 */
public class RedefineClassDemo {
    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
//        test1();
        test2();
    }





    public  static void test1() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class<?> clazz = buildClass1("MyClass");
        Method m = clazz.getDeclaredMethod("hello", null);
        System.out.println(m.invoke(clazz.newInstance(),null));
    }

    public static Class<?> buildClass1(String className){
        return new ByteBuddy()
                .subclass(Object.class)
                .name("MyClass")
                .defineMethod("hello",String.class, Modifier.PUBLIC)
                .intercept(MethodDelegation.to(Bar.class))
                .defineField("name",String.class,Modifier.PRIVATE)
                .make()
                .load(RedefineClassDemo.class.getClassLoader(), ClassLoadingStrategy.Default.WRAPPER)
                .getLoaded();
    }

    public static void test2(){
        redefinedClass();
    }

    public static void redefinedClass(){
        ByteBuddyAgent.install();
        new ByteBuddy()
                .redefine(Foo.class)
                .method(named("sayFoo"))
                .intercept(FixedValue.value("hello SB!"))
                .make()
                .load(RedefineClassDemo.class.getClassLoader(), ClassReloadingStrategy.fromInstalledAgent())
                .getLoaded();

        Foo foo = new Foo();
        System.out.println(foo.sayFoo());
    }
}
