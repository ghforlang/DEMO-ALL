package com.edu.nbu.cn.innerclass;


import java.util.Arrays;
import java.util.List;

/**
 *
 * @version 1.0
 * @Date 2021/6/22 5:38 下午
 * @since 1.0
 */
public class AnonymousClassDemo {
    private static final String name = "anonymous";
    public static void main(String[] args) {
        NotifyListener listener = new NotifyListener() {
            static final String name = "hello";
            String age;

            {
                if (age.equals(name)){
                    System.out.println(age);
                }
            }
            @Override
            public void notify(List<String> urls) {
                System.out.println(name + "," + urls);
            }
        };
        listener.notify(Arrays.asList("hahahah"));



        NotifyListener listener1 = p -> {
            AnonymousClassDemo.print(p);
        };

        NotifyListener listener2 = AnonymousClassDemo::print;
        listener1.notify(Arrays.asList("lambda listener 1"));
    }


    public static void print(List<String> urls){
        System.out.println(urls);
    }
}
