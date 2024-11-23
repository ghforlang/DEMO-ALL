package com.edu.nbu.cn.boot.ext.controller;

import com.edu.nbu.cn.boot.ext.imports.model.ImportBeanDefinitionRegistrarBean;
import com.edu.nbu.cn.boot.ext.imports.model.ImportCommonBean;
import com.edu.nbu.cn.boot.ext.imports.model.ImportSelectorBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author laoshi . hua
 * @version 1.0 2023/2/9-10:19 AM
 * @since 1.0
 */
@RestController
@RequestMapping("/import")
@Slf4j
public class ImportController {

    @Resource
    private ImportCommonBean importCommonBean;
    @Resource
    private ImportSelectorBean importSelectorBean;
    @Resource
    private ImportBeanDefinitionRegistrarBean importBeanDefinitionRegistrarBean;

    @RequestMapping("/commonBean")
    public void commonBean(){
        importCommonBean.setBeanName("张三");
        importCommonBean.setBeanContent("张三的哥哥叫张四!");
        log.info("importCommonBean info : {}",importCommonBean.getBeanName() + " : " + importCommonBean.getBeanContent());
    }

    @RequestMapping("/importSelectorImpl")
    public void importSelector(){
        importSelectorBean.setBeanName("张");
        importSelectorBean.setBeanContent("张的哥哥叫张1!");
        log.info("importSelectorBean info : {}",importSelectorBean.getBeanName() + " : " + importSelectorBean.getBeanContent());
    }

    @RequestMapping("/importBeanDefinitionRegist")
    public void importBeanDefinitionRegist(){
        importBeanDefinitionRegistrarBean.setBeanName("李");
        importBeanDefinitionRegistrarBean.setBeanContent("李的哥哥叫李1!");
        log.info("importBeanDefinitionRegistrarBean info : {}",importBeanDefinitionRegistrarBean.getBeanName() + " : " + importSelectorBean.getBeanContent());
    }
}
