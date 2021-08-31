package com.edu.nbu.cn.stackoverflow.uncollected;

import java.lang.reflect.Method;
import java.net.URL;

public class TLTest {
    private Object aaa;

    public static void main(String args[]){
        try {
            TLTest tt = new TLTest();
            //将对象移到old，并置空aaa的aab属性
            test(tt);
            //清理掉aab对象
            System.gc();
            //断点，并做dump
            System.out.println("finished");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @SuppressWarnings("resource")
    public static void test(TLTest tt){
        try {
            //创建一个新的类加载器，从AAA.jar里加载AAA类
            URL[] urls = new URL[1];
            urls[0] = new URL("file:E:\\workspace\\JVM-OOM\\target\\classes");
            tt.aaa=new TestLoader(urls).loadClass("com.edu.nbu.cn.stackoverflow.uncollected.AA").newInstance();
            //保证类加载器对象能进入到old里，因为ygc是不会对classLoader做清理的
            for(int i=0;i<10;i++){
                System.gc();
                Thread.sleep(1000);
            }
            //将aaa里的aab属性清空掉，以便在后面gc的时候能清理掉aab对象，这样AAB的类加载器其实就没有什么地方有强引用了，在full gc的时候能被回收
            Method[] methods=tt.aaa.getClass().getDeclaredMethods();
            for(Method m:methods){
                if(m.getName().equals("clear")){
                    m.invoke(tt.aaa);
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
