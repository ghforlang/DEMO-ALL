package com.edu.nbu.cn.generic;

import com.edu.nbu.cn.generic.model.Foo;
import com.edu.nbu.cn.generic.model.ListWrapper;
import com.edu.nbu.cn.generic.model.Wrapper;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @author laoshi . hua
 * @version 1.0 2023/5/25-10:25 AM
 * @since 1.0
 */
public class GenericTest {

    public static void main(String[] args) {
        System.out.println(GenericUtils.getGenericClass(new ArrayList<String>()));
        Type type1 = GenericUtils.getGenericRuntimeType(new Wrapper<List<String>>());
        Type type2 = GenericUtils.getGenericRuntimeType(new Wrapper<List<String>>() {});
        Type type3 = GenericUtils.getGenericRuntimeType(new ListWrapper());
        System.out.println(type1);
        System.out.println(type2);
        System.out.println(type3);
        new Wrapper<List<String>>().initialize();
    }
}
