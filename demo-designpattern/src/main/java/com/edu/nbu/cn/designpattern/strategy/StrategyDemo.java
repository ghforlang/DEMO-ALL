package com.edu.nbu.cn.designpattern.strategy;

import com.edu.nbu.cn.designpattern.strategy.context.OperationEnum;
import com.edu.nbu.cn.designpattern.strategy.context.StrategyContext;

/**
 * @author laoshi . hua
 * @version 1.0 2023/5/6-2:40 PM
 * @since 1.0
 */
public class StrategyDemo {

    public static void main(String[] args) {
        System.out.println("1 + 2 = " + StrategyContext.dualOperate(1,2, OperationEnum.ADD));
        System.out.println("1 - 2 = " + StrategyContext.dualOperate(1,2, OperationEnum.SUBTRACT));
        System.out.println("1 * 2 = " + StrategyContext.dualOperate(1,2, OperationEnum.MUL));
    }
}
