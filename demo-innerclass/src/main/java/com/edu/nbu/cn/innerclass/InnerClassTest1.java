package com.edu.nbu.cn.innerclass;

import com.edu.nbu.cn.demo.registrar.MyAutoConfigurationBeanRegistrar;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 *
 * @version 1.0
 * @Date 2021/6/21 9:17 下午
 * @since 1.0
 */
public class InnerClassTest1 {
    private static final List<String> urls = Arrays.asList("this is a innerClass test!");
    public static void main(String[] args) {
        final AtomicReference<List<String>> reference = new AtomicReference<>();
        NotifyListener listener = new NotifyListener() {
            @Override
            public void notify(List<String> urls) {
                reference.set(urls);
            }
        };
        listener.notify(urls);

        List<String> result = reference.get();
        result.forEach(System.out::println);

        System.out.println("*******************************");
        MyListener myListener = new MyListener();
        myListener.notify(urls);
        List<String> result1 = reference.get();
        result1.forEach(System.out::println);
    }

    private static final class MyListener implements NotifyListener{

        @Override
        public void notify(List<String> urls) {
            System.out.println("this is myListener!");
        }
    }
}
