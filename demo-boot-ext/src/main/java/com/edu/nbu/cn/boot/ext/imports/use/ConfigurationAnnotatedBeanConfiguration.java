package com.edu.nbu.cn.boot.ext.imports.use;

import com.edu.nbu.cn.boot.ext.imports.model.ImportCommonBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;

/**
 * @author laoshi . hua
 * @version 1.0 2023/2/9-10:24 AM
 * @since 1.0
 */
@Configuration
//通过@Import注解引入@Configuration注解的配置类，
// 会把该配置类相关@Import、@ImportResource、@PropertySource
// 等注解引入的类进行递归，一次性全部引入
@Import(CommonBeanConfiguration.class)
public class ConfigurationAnnotatedBeanConfiguration {
    //所以这里可以拿到ImportCommonBean
    @Resource
    private ImportCommonBean importCommonBean;
}
