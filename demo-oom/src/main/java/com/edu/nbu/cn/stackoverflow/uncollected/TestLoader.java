package com.edu.nbu.cn.stackoverflow.uncollected;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.WeakHashMap;

public class TestLoader extends URLClassLoader {
    public static WeakHashMap<TestLoader,Object> map=new WeakHashMap<TestLoader,Object>();
    private static int count=0;
    public TestLoader(URL[] urls){
        super(urls);
        map.put(this, new Object());
    }
    @SuppressWarnings("resource")
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if(name.equals("BB") && count==0){
            try {
                count=1;
                URL[] urls = new URL[1];
                urls[0] = new URL("file:E:\\workspace\\DEMO-ALL\\target\\classes");
                return new TestLoader(urls).loadClass("com.edu.nbu.cn.stackoverflow.uncollected.BB");
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            return super.loadClass(name);
        }
        return null;
    }

}
