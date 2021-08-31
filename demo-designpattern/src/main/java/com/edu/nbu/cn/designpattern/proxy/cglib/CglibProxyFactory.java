package com.edu.nbu.cn.designpattern.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyFactory implements MethodInterceptor {

    private Object realObject;

    /**
     *
     * @param realObject 被代理对象
     * @param method 被拦截的方法
     * @param objects 被拦截的方法入参
     * @param methodProxy 方法代理，用于代理原始的方法
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object realObject, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("do something before proxy");
        Object object = methodProxy.invokeSuper(realObject,objects);
        System.out.println("do something before proxy");
        return object;
    }

    //创建代理对象实例
    public Object getProxyInstance(Object realObject){
        this.realObject = realObject;
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(realObject.getClass().getClassLoader());
        enhancer.setSuperclass(realObject.getClass());
        enhancer.setCallback(this);
        return  enhancer.create();
    }

    public Object getRealObject() {
        return realObject;
    }

    public void setRealObject(Object realObject) {
        this.realObject = realObject;
    }
}
