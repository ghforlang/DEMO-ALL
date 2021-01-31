package com.edu.nbu.cn.demo.classloader;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;


/**
 * 自定义类加载器，可以实现动态替换，参考OSGI
 * 模拟应用不重启，实现类的动态加载，详情参考TestMyClassLoader
 */
public class MyClassLoader extends ClassLoader{

    private static final String filePath = "/Users/fanwenhao/my-projects/JVM-OOM/target/classes/com/edu/nbu/cn/demo/classloader/TestCl.class";

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {

        Class<?> clazz = this.findLoadedClass(name);
        if(clazz != null){
            return clazz;
        }

        clazz = this.findSystemClass(name);
        if(clazz != null){
            return clazz;
        }

        if(clazz == null){
            try(
                    FileInputStream fis = new FileInputStream(filePath);
                    FileChannel fileChannel = fis.getChannel();
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    WritableByteChannel wbc = Channels.newChannel(baos);
                    ){
                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                while(true){
                    int i = fileChannel.read(byteBuffer);
                    if(i == 0 || i == -1){
                        break;
                    }
                    byteBuffer.flip();
                    wbc.write(byteBuffer);
                    byteBuffer.clear();
                }
                byte[] bytes = baos.toByteArray();
                clazz = defineClass(name,bytes,0,bytes.length);

            }catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return super.loadClass(name);
    }
}
