package com.edu.nbu.cn.spring.function.core;

import com.edu.nbu.cn.spring.factory.FactoryHolder;
import com.edu.nbu.cn.spring.factory.FunctionFactory;
import com.edu.nbu.cn.spring.function.core.anno.FunctionBean;
import com.edu.nbu.cn.spring.function.core.anno.FunctionInterface;
import com.edu.nbu.cn.spring.function.core.anno.FunctionMethod;
import com.edu.nbu.cn.spring.function.core.meta.FunctionMethodMetaData;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.env.Environment;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * @author laoshi . hua
 * @version 1.0 2022/6/18-5:57 PM
 * @since 1.0
 */
public class FunctionBeanRegisterPostProcessor implements BeanPostProcessor,
        BeanFactoryAware, EnvironmentAware, ApplicationContextAware,DisposableBean{

    private BeanFactory beanFactory;
    private ApplicationContext applicationContext;
    private Environment environment;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void destroy() throws Exception {
    }


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        FunctionBean annotation = AnnotationUtils.findAnnotation(bean.getClass(), FunctionBean.class);
        if (annotation != null) {
            processBeforeInitialization(bean, beanName);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }


    private void processBeforeInitialization(Object bean, String beanName){
        Object target = bean;
        FunctionFactory factory = FactoryHolder.getInstance().get();

        Class<?>[] beanParents = bean.getClass().getInterfaces();
        boolean functionBean = false;
        Class<?> functionParent = null;
        for(Class<?> parent : beanParents){
            if(parent.isAnnotationPresent(FunctionInterface.class)){
                functionBean = true;
                functionParent = parent;
                break;
            }
        }

        if(!functionBean){
            System.out.println("not a functionBean!");
            return;
        }

        Class<?> beanClazz = target.getClass();
        Set<Method> candidateMethods = new HashSet<>();
        for (Method method : beanClazz.getMethods()){
            if(Objects.nonNull(method.getAnnotation(FunctionMethod.class))){
                candidateMethods.add(method);
            }
        }

        if(CollectionUtils.isEmpty(candidateMethods)){
            return;
        }

        // buildMethodMetaData
        List<FunctionMethodMetaData> methodMetaDataList = new ArrayList<>();
        candidateMethods.forEach(method -> methodMetaDataList.add(buildMethodMetaData(method,target,beanName)));

        //register function
        for (FunctionMethodMetaData methodMetaData : methodMetaDataList) {
            factory.register(functionParent,methodMetaData.getIdentifier(),methodMetaData.getFunction());
        }
    }

    private FunctionMethodMetaData buildMethodMetaData(Method method,Object bean, String beanName){
        FunctionMethod anno = method.getAnnotation(FunctionMethod.class);

        FunctionMethodMetaData methodMetaData = new FunctionMethodMetaData();
        methodMetaData.setIdentifier(anno.identifier());
        methodMetaData.setBeanName(beanName);
        methodMetaData.setBeanClazz(bean.getClass());

        Parameter[] parameters = method.getParameters();
        if(parameters.length != 1){
            throw new BeanCreationException("unsupport operation!");
        }
        methodMetaData.setFunction(param -> {
            try {
                return method.invoke(bean,param);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        });
        return methodMetaData;
    }

}
