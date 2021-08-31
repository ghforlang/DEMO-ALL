package com.edu.nbu.cn.innerclass;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 *
 * @version 1.0
 * @Date 2021/6/21 9:11 下午
 * @since 1.0
 */
public class InnerClassTest {
    private static final List<String> urls = Arrays.asList("this is a innerClass test!");
    public static void main(String[] args) {
        final AtomicReference<List<String>> reference = new AtomicReference<>();
        NotifyListener listener = reference::set;
        listener.notify(urls);

        List<String> result = reference.get();
        result.forEach(System.out::println);

        NotifyListener listeners = reference::set;
    }
}
