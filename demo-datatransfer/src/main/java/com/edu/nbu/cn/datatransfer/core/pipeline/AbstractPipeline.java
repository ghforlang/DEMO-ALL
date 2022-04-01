package com.edu.nbu.cn.datatransfer.core.pipeline;

import com.alibaba.fastjson.JSON;
import com.edu.nbu.cn.datatransfer.core.source.StageResult;
import com.edu.nbu.cn.datatransfer.exception.IllegalNameException;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/25-4:13 下午
 * @since 1.0
 */
@Slf4j
public class AbstractPipeline implements Pipeline{

    private final Map<String,Stage> stageRegistry = new HashMap<>();
    private static List<Stage> stages = new LinkedList<>();


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
        Collections.sort(stages);
        for (int i=0;i<stages.size();i++){
            Stage curStage = stages.get(i);
            StageResult previousResult = null;
            if(i != 0){
                previousResult = stages.get(i-1).stageResult();
            }
            if(curStage.usePreviousResult() && Objects.isNull(previousResult)){
                log.warn("need use previousStageResult,but no previousResult can be used,maybe need adjust the order!");
                throw  new IllegalNameException("need use previousStageResult,but no previousResult can be used,maybe need adjust the order!");
            }

            if(curStage.resource().hasResult()){
                StageResult result = curStage.getExecutor().executeWithReturn(curStage.resource(),previousResult);
                curStage.assembleResult(result);
                log.info("executor with result : " + JSON.toJSONString(result));
            }else {
                curStage.getExecutor().execute(curStage.resource(), previousResult);
            }
        }
    }
}
