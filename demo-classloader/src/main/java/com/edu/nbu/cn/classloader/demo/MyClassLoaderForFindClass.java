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
 * @version 1.0 2023/7/27-5:12 PM
 * @since 1.0
 */
public class MyClassLoaderForFindClass extends ClassLoader{

    private static final Map<String,String> classpathMap = new HashMap<>();

    static{
        classpathMap.put("com.edu.nbu.cn.classloader.demo.testA","/Users/fanwenhao/my-projects/DEMO-ALL/demo-classloader/target/classes/com/edu/nbu/cn/classloader/demo/TestA.class");
        classpathMap.put("com.edu.nbu.cn.classloader.demo.testB","/Users/fanwenhao/my-projects/DEMO-ALL/demo-classloader/target/classes/com/edu/nbu/cn/classloader/demo/TestB.class");
    }


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String classPath = classpathMap.get(name);
        File file = new File(classPath);
        if(!file.exists()){
            System.out.println("file not exists!");
            throw new ClassNotFoundException();
        }

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
