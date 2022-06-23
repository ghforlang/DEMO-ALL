package com.edu.nbu.cn.spring.function.core.cofiguration;

import com.edu.nbu.cn.spring.function.core.FunctionBeanRegisterPostProcessorRegistrar;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author laoshi . hua
 * @version 1.0 2022/6/22-5:27 PM
 * @since 1.0
 */
@Configuration
@Import(FunctionBeanRegisterPostProcessorRegistrar.class)
public class FunctionBeanConfiguration {

}
