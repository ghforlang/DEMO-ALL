package com.edu.nbu.cn.demo;

import com.edu.nbu.cn.InnerClass;

/**
 *
 * @version 1.0
 * @Date 2021/6/21 5:57 下午
 * @since 1.0
 */
public class InnerClassDemo {

    public static void main(String[] args) {
        InnerClass innerClass = new InnerClass() {
            @Override
            public void print() {
                System.out.println("Im innerClass of InnerClass");
            }
        };
        innerClass.print();
    }

    InnerClass innerClass1 = this::printSth;

    private void printSth(){
        System.out.println("Im innerClass of InnerClass");
    }
}
