package com.edu.nbu.cn.datatransfer.core.pipeline;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/25-3:19 下午
 * @since 1.0
 */
public interface Pipeline {

    void plugin(Stage ...stages);

    void execute();
}
