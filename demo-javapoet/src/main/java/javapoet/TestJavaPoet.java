package javapoet;

import javapoet.annotation.JavaPoet;
import javapoet.model.A;
import javapoet.model.Activity;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import lombok.SneakyThrows;

import javax.lang.model.element.Modifier;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @version 1.0
 * @Date 2021/2/5 5:32 下午
 * @since 1.0
 */
public class TestJavaPoet {

    @SneakyThrows
    public static void main(String[] args) {
        TypeSpec typeSpec = generateClass(Activity.class);
        JavaFile file = JavaFile.builder("com.edu.nbu.cn.demo.javapoet.model",typeSpec).build();
        File clazzFile = new File("/Users/charen/my-project/DEMO-ALL/src/main/java/com/edu/nbu/cn/demo/javapoet/model");
        file.writeTo(clazzFile);

        TypeSpec typeSpec1 = generateAbstractClass(Activity.class);
        JavaFile file1 = JavaFile.builder("com.edu.nbu.cn.demo.javapoet.model",typeSpec1).build();
        File abstractClazzFile = new File("/Users/charen/my-project/DEMO-ALL/src/main/java/com/edu/nbu/cn/demo/javapoet/model");
        file1.writeTo(abstractClazzFile);
    }

    @SneakyThrows
    private static MethodSpec generateAbstractMethod(String methodName, Class<?> clazz){
        if(!validateClass(clazz)){
            throw new RuntimeException("当前class不支持扩展！");
        }

        Method method = clazz.getDeclaredMethod(methodName, A.class);
        if(Objects.isNull(method)){
            throw new RuntimeException("当前扩展方法不属于当前class！");
        }

        return MethodSpec.methodBuilder(methodName)
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(Override.class)
                .returns(method.getReturnType())
                .addParameter(A.class,"a",Modifier.FINAL)
                .build();
    }



    @SneakyThrows
    private static MethodSpec generateMethod(String methodName, Class<?> clazz){
        if(!validateClass(clazz)){
            throw new RuntimeException("当前class不支持扩展！");
        }

        Method method = clazz.getDeclaredMethod(methodName,A.class);
        if(Objects.isNull(method)){
            throw new RuntimeException("当前扩展方法不属于当前class！");
        }

        MethodSpec methodSpec = MethodSpec.methodBuilder(methodName)
                .addModifiers(Modifier.PUBLIC)
                .returns(method.getReturnType())
                .addAnnotation(Override.class)
                .addParameter(A.class,"a",Modifier.FINAL)
                .addStatement("$T.out.println($S)",System.class,"this is ")
//                .addStatement("a.$N","getActivityName()")
                .build();
        return methodSpec;
    }

    private static TypeSpec generateAbstractClass(Class<?> clazz){
        if(!validateClass(clazz)){
            throw new RuntimeException("当前class不支持扩展");
        }

        Method[] methods = Activity.class.getDeclaredMethods();
        List<MethodSpec> methodSpecList = new ArrayList<>();
        for (Method method : methods){
            methodSpecList.add(generateAbstractMethod(method.getName(),Activity.class));
        }

        TypeSpec demoActivity = TypeSpec.classBuilder("AbstractDemoActivity")
                .addAnnotation(JavaPoet.class)
                .addModifiers(new Modifier[]{Modifier.ABSTRACT})
                .addMethods(methodSpecList)
                .addSuperinterface(Activity.class)
                .build();
        return demoActivity;
    }

    private static TypeSpec generateClass(Class<?> clazz){
        if(!validateClass(clazz)){
            throw new RuntimeException("当前class不支持扩展");
        }

        Method[] methods = Activity.class.getDeclaredMethods();
        List<MethodSpec> methodSpecList = new ArrayList<>();
        for (Method method : methods){
            methodSpecList.add(generateMethod(method.getName(),Activity.class));
        }

        TypeSpec demoActivity = TypeSpec.classBuilder("DemoActivity")
                .addAnnotation(JavaPoet.class)
                .addModifiers(new Modifier[]{Modifier.FINAL,Modifier.PUBLIC})
                .addMethods(methodSpecList)
                .addSuperinterface(Activity.class)
                .build();
        return demoActivity;
    }

    private static boolean validateClass(Class<?> clazz){
        if(Objects.isNull(clazz)){
            return false;
        }
        if(java.lang.reflect.Modifier.isFinal(clazz.getModifiers()) || java.lang.reflect.Modifier.isNative(clazz.getModifiers())
                || java.lang.reflect.Modifier.isPrivate(clazz.getModifiers())){
            return false;
        }
        return true;
    }

}
