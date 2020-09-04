package com.edu.nbu.cn.proxy.factory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyFactory implements InvocationHandler {

    private Object proxiedObj;

    public ProxyFactory(Object proxiedObj) {
        this.proxiedObj = proxiedObj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doBeforeInvoke();
        Object object = method.invoke(proxiedObj,args);
        doAfterInvoke();
        return object;
    }

    private void doBeforeInvoke(){
        System.out.println("do before invoke!");
    }

    private void doAfterInvoke(){
        System.out.println("do after invoke!");
    }

    public void setProxiedObj(Object obj){
        this.proxiedObj = proxiedObj;
    }

    public Object getProxiedObj(){
        return proxiedObj;
    }
}
