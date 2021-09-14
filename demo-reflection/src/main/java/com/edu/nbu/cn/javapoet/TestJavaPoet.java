package com.edu.nbu.cn.javapoet;

import com.edu.nbu.cn.javapoet.model.ActivityInterface;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;

import java.io.File;
import java.io.IOException;

public class TestJavaPoet {

    public static void main(String[] args) throws IOException {
        TypeSpec typeSpec = ClassGenerator.generate(ActivityInterface.class,"DemoActivity");
        JavaFile javaFile = JavaFile.builder("",typeSpec).build();
        String filePath = TestJavaPoet.class.getResource("/com/edu/nbu/cn/demo/javapoet/model").getPath();
        File file = new File(filePath);
        javaFile.writeTo(file);
    }
}
