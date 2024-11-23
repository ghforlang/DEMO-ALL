package com.edu.nbu.cn.boot.ext.scope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

/**
 * @author laoshi . hua
 * @version 1.0 2023/2/9-2:48 PM
 * @since 1.0
 */
public class ThreadLocalScope implements Scope {

    private static final ThreadLocal THREAD_LOCAL_SCOPE = new ThreadLocal();

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
       Object value = THREAD_LOCAL_SCOPE.get();
       if(value != null){
           return value;
       }
       Object obj = objectFactory.getObject();
       THREAD_LOCAL_SCOPE.set(obj);
        return obj;
    }

    @Override
    public Object remove(String name) {
        THREAD_LOCAL_SCOPE.remove();
        return null;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
