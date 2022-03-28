package com.edu.nbu.cn.datatransfer.core;

import com.edu.nbu.cn.datatransfer.core.pipeline.DefaultPipeline;
import com.edu.nbu.cn.datatransfer.core.pipeline.DefaultStage;
import com.edu.nbu.cn.datatransfer.core.pipeline.Stage;
import com.edu.nbu.cn.datatransfer.core.source.DefaultExecutor;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/25-3:17 下午
 * @since 1.0
 */
public class Test {

    public static void main(String[] args) {

        DefaultPipeline pipeline = new DefaultPipeline();

        DefaultStage stage1 = new DefaultStage.Builder("test")
                .sourceName("test.sql")
                .executor(new DefaultExecutor())
                .order(112)
                .build();

        pipeline.plugin(new Stage[]{stage1});

        pipeline.execute();
    }
}
