package com.edu.nbu.cn.stackoverflow;

import java.io.File;
import java.lang.reflect.Array;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

public class TestMetaspaceOutOfMemory {

    public static void main(String[] args) {
        URL url = null;
        List<ClassLoader> loaderList = new ArrayList<>();
        try{
            url = new File("/").toURI().toURL();
            URL[] urls= {url};
            while (true){
                ClassLoader cl = new URLClassLoader(urls);
                loaderList.add(cl);
                cl.loadClass("com.edu.nbu.cn.TestLocalDateTime");
            }
        }catch(Throwable e){
            e.printStackTrace();
        }
    }
}
