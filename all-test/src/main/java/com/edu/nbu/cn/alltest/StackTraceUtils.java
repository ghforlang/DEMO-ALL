package com.edu.nbu.cn.alltest;

/**
 * @author laoshi . hua
 * @version 1.0 2022/8/23-3:23 PM
 * @since 1.0
 */
public class StackTraceUtils {

    private static final String MainMethodName = "main";

    public static Class<?> getMainClass(){
        StackTraceElement[] stes = new RuntimeException().getStackTrace();
        for (StackTraceElement steEle : stes){
            if(MainMethodName.equals(steEle.getMethodName())){
                try {
                    return Class.forName(steEle.getClassName());
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return null;
    }
}
