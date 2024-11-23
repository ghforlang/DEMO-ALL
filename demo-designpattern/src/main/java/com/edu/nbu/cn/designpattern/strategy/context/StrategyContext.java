package com.edu.nbu.cn.designpattern.strategy.context;

import com.edu.nbu.cn.designpattern.strategy.AddOperationStrategy;
import com.edu.nbu.cn.designpattern.strategy.MultipOperationStrategy;
import com.edu.nbu.cn.designpattern.strategy.OperationStrategy;
import com.edu.nbu.cn.designpattern.strategy.SubstractOperationStrategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author laoshi . hua
 * @version 1.0 2023/5/6-2:38 PM
 * @since 1.0
 */
public class StrategyContext {
    private static final Map<OperationEnum,OperationStrategy> operationStrategyMap = new HashMap<>();


    static{
        operationStrategyMap.put(OperationEnum.ADD,new AddOperationStrategy());
        operationStrategyMap.put(OperationEnum.SUBTRACT,new SubstractOperationStrategy());
        operationStrategyMap.put(OperationEnum.MUL,new MultipOperationStrategy());
    }



    public static int dualOperate(int x,int y,OperationEnum operationEnum){
        return operationStrategyMap.get(operationEnum).dualOperation(x,y);
    }
}
