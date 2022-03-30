package com.edu.nbu.cn.datatransfer.core.pipeline;

import org.springframework.stereotype.Component;

/**
* @author laoshi . hua
* @since 1.0 
* @version 1.0 2022/3/25-5:34 下午
*/
@Component
public class DefaultPipeline extends AbstractPipeline{


    @Override
    public void plugin(Stage... stages) {
        super.plugin(stages);
    }

    @Override
    public void execute() {
        super.execute();
    }
}
