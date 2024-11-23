package com.edu.nbu.cn.designpattern.strategy;

/**
 * @author laoshi . hua
 * @version 1.0 2023/5/6-2:37 PM
 * @since 1.0
 */
public class MultipOperationStrategy implements OperationStrategy{
    @Override
    public int dualOperation(int firstNum, int secondNum) {
        return firstNum * secondNum;
    }
}
