package com.edu.nbu.cn.boot.ext.imports.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author laoshi . hua
 * @version 1.0 2023/2/9-10:43 AM
 * @since 1.0
 */
@Getter
@Setter
public class ImportBeanDefinitionRegistrarBean {
    private String beanName;
    private String beanContent;
}
