package com.edu.nbu.cn.reflection.javassist;

import com.edu.nbu.cn.reflection.Param;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.NotFoundException;
import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@UtilityClass
public final class HelperFactory {


    private static final Map<Class<?>, AbstractEntityHelper> ENTITY_HELPER_MAP = new HashMap<>();

    public static AbstractEntityHelper createEntityHelper(Class<?> entityClazz) throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException, IOException {
        if(Objects.isNull(entityClazz)){
            return null;
        }

        AbstractEntityHelper helper = ENTITY_HELPER_MAP.get(entityClazz);
        if(null != helper){
            return helper;
        }

        ClassPool pool = ClassPool.getDefault();
        pool.appendSystemPath();

        //导入相关类,生成如下代码
        // import com.edu.nbu.cn.demo.reflection.Param;
        // import xxx.xxx.xxx.entityClazz;
        pool.importPackage(Param.class.getName());
        pool.importPackage(entityClazz.getName());

        CtClass abstractEntityHelperClazz = pool.getCtClass(AbstractEntityHelper.class.getName());
        final String helperImplClazzName = entityClazz.getName() + "HelplerImpl";

        //makeClass 两个参数，一个是要创建的类名，一个是父类
        // 会生类似如下代码 public class StudentHelplerImpl extens AbstractEntityHelper{
        CtClass entityHelperClazz = pool.makeClass(helperImplClazzName,abstractEntityHelperClazz);

        //创建 默认构造方法
        CtConstructor defaultConstructor = new CtConstructor(new CtClass[0],entityHelperClazz);
        defaultConstructor.setBody("{}");
        entityHelperClazz.addConstructor(defaultConstructor);

        //创建函数代码
        final StringBuffer sb = new StringBuffer();
        sb.append("public Object create(com.edu.nbu.cn.demo.reflection.Param param) throws Exception {\n");
        sb.append(entityClazz.getName());
        sb.append(" obj = new ");
        sb.append(entityClazz.getName());
        sb.append("();\n");

        //字段赋值
        Field[] fields = entityClazz.getDeclaredFields();
        for(Field field : fields){
            String getFieldMethodName = "get" + field.getName().substring(0,1).toUpperCase() + field.getName().substring(1) + "()";
            String setFieldMethodName = "set" + field.getName().substring(0,1).toUpperCase() + field.getName().substring(1);
//            sb.append("if(null != param." + getFieldMethodName + "){\n");
            sb.append("obj." + setFieldMethodName + "(" + "param." + getFieldMethodName + ");\n");
//            sb.append("} \n");
        }

        //返回值
        sb.append("return obj;\n");
        sb.append("}");

        CtMethod ctMethod = CtNewMethod.make(sb.toString(),entityHelperClazz);
        entityHelperClazz.addMethod(ctMethod);
//        entityHelperClazz.writeFile("E:/workspace/JVM-OOM/reflection");

        Class<?> javaClazz = entityHelperClazz.toClass();
        helper = (AbstractEntityHelper) javaClazz.newInstance();
        ENTITY_HELPER_MAP.putIfAbsent(entityClazz,helper);
        return helper;
    }
}
