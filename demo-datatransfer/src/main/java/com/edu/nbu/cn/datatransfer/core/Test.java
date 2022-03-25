package com.edu.nbu.cn.datatransfer.core;

import com.edu.nbu.cn.datatransfer.core.pipeline.DefaultPipeline;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/25-3:17 下午
 * @since 1.0
 */
public class Test {

    public static void main(String[] args) {

        DefaultPipeline pipeline = new DefaultPipeline();

        pipeline.plugin();
    }
}
