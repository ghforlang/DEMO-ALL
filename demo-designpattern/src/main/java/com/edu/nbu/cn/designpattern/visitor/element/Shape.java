package com.edu.nbu.cn.designpattern.visitor.element;

import com.edu.nbu.cn.designpattern.visitor.visitor.Visitor;

/**
 * @author laoshi . hua
 * @version 1.0 2022/9/2-3:35 PM
 * @since 1.0
 */
public interface Shape {

    void move(int x, int y);

    void draw();

    String accept(Visitor visitor);
}
