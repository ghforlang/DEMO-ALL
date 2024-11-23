package com.edu.nbu.cn.bytebuddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;

/**
 * @author laoshi . hua
 * @version 1.0 2023/7/27-2:13 PM
 * @since 1.0
 */
public class Demo {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        DynamicType.Unloaded unloadedType = new ByteBuddy()
                .subclass(Object.class)
                .method(ElementMatchers.isToString())
                .intercept(FixedValue.value("fuck you!"))
                .make();
        Class<?> loadedClass = unloadedType.load(Demo.class.getClassLoader()).getLoaded();
        System.out.println(loadedClass.newInstance().toString());

    }
}
