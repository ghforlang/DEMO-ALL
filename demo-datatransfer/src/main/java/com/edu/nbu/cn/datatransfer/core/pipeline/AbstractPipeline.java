package com.edu.nbu.cn.datatransfer.core.pipeline;

import com.alibaba.fastjson.JSON;
import com.edu.nbu.cn.datatransfer.core.source.StageResult;
import org.apache.ibatis.jdbc.ScriptRunner;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/25-4:13 下午
 * @since 1.0
 */
public class AbstractPipeline implements Pipeline{

    private final Map<String,Stage> stageRegistry = new HashMap<>();
    private final List<Stage> stages = new LinkedList<>();




    private void plugin(Stage stage) {
        stageRegistry.put(stage.name(),stage);
        stages.add(stage);
    }

    @Override
    public void plugin(Stage ...stages) {
        for (Stage stage : stages){
            plugin(stage);
        }
    }

    @Override
    public void execute() {
        stages.stream().sorted();
        stages.forEach(stage ->{
            if(stage.resource().hasResult()){
                StageResult result = stage.getExecutor().executeWithReturn(stage.resource());
                System.out.println(JSON.toJSONString(result));
            }else{
                stage.getExecutor().execute(stage.resource());
            }
        });
    }
}
