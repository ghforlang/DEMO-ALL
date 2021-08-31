package com.edu.nbu.cn.classloader;

import lombok.SneakyThrows;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Objects;

/**
 *
 * @version 1.0
 * @Date 2021/1/29 11:38 上午
 * @since 1.0
 */
public class MyClassLoader extends ClassLoader{

    private static final String clazzPath = "/Users/charen/my-project/DEMO-ALL/demo-classloader/target/classes/classloader/TestCl.class";
    private static final String PREFIX_LANG_PAK = "java.lang.";
    @SneakyThrows
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


        if (Objects.isNull(clazz)) {
            try(FileInputStream fileInputStream = new FileInputStream(clazzPath);
                FileChannel fileChannel = fileInputStream.getChannel();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                WritableByteChannel wbc = Channels.newChannel(baos);
            ){
                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                while (true) {
                    int i = fileChannel.read(byteBuffer);
                    if (i == 0 || i == -1) {
                        break;
                    }
                    byteBuffer.flip();
                    wbc.write(byteBuffer);
                    byteBuffer.clear();
                }
                byte[] bytes = baos.toByteArray();
                clazz = defineClass(name, bytes, 0, bytes.length);
            }catch (IOException ioException){
                ioException.printStackTrace();
            }
        }
        return clazz;
    }
}
