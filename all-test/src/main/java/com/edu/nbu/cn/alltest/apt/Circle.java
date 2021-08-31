package com.edu.nbu.cn.alltest.apt;

import com.edu.nbu.cn.apt.anno.Build;

/**
 * @version 1.0
 * @Date 2021/8/3 8:07 下午
 * @since 1.0
 */
@Build(bizId = "circle",type = IShape.class,group = "com.edu.nbu.cn.alltest.apt.IShape")
public class Circle implements IShape{
    @Override
    public void draw() {
        System.out.println("draw a circle!");
    }
}
