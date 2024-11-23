package com.edu.nbu.cn.designpattern.strategy;

/**
 * @author laoshi . hua
 * @version 1.0 2023/5/6-2:35 PM
 * @since 1.0
 */
public class AddOperationStrategy implements OperationStrategy{
    @Override
    public int dualOperation(int firstNum, int secondNum) {
        return firstNum + secondNum;
    }
}
