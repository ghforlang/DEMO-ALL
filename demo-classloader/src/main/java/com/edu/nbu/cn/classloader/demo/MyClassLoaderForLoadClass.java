package com.edu.nbu.cn.classloader.demo;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author laoshi . hua
 * @version 1.0 2023/7/27-5:25 PM
 * @since 1.0
 */
public class MyClassLoaderForLoadClass extends ClassLoader{
    private static final Map<String,String> classpathMap = new HashMap<>();

    static{
        classpathMap.put("com.edu.nbu.cn.classloader.demo.testA","/Users/fanwenhao/my-projects/DEMO-ALL/demo-classloader/target/classes/com/edu/nbu/cn/classloader/demo/TestA.class");
        classpathMap.put("com.edu.nbu.cn.classloader.demo.TestB","/Users/fanwenhao/my-projects/DEMO-ALL/demo-classloader/target/classes/com/edu/nbu/cn/classloader/demo/TestB.class");
    }

    private ClassLoader jdkClassLoader;

    public MyClassLoaderForLoadClass(ClassLoader jdkClassLoader) {
        this.jdkClassLoader = jdkClassLoader;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        Class result = null;

        try{
            if(!name.startsWith("com.edu.nbu.cn.classloader.demo")){
                result = jdkClassLoader.loadClass(name);
            }
        }catch(ClassNotFoundException ex){

        }

        if(result != null){
            return result;
        }

        File file = new File(classpathMap.get(name));
        byte[] classBytes = loadClassData(file);
        return defineClass(classBytes, 0,classBytes.length);
    }

    private byte[] loadClassData(File file) throws ClassNotFoundException{
        try(InputStream ins = new FileInputStream(file); ByteArrayOutputStream bos = new ByteArrayOutputStream()){
            byte[] buffer = new byte[4096];
            int byteRead = 0;
            while((byteRead = ins.read(buffer)) != -1){
                bos.write(buffer,0, byteRead);
            }
            return bos.toByteArray();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
