package com.edu.nbu.cn.designpattern.visitor.element;

import com.edu.nbu.cn.designpattern.visitor.visitor.Visitor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author laoshi . hua
 * @version 1.0 2022/9/2-3:40 PM
 * @since 1.0
 */
@Getter
@Setter
public class Circle  extends  Dot{
    private int radius;

    public Circle(int id, int x, int y, int radius) {
        super(id, x, y);
        this.radius = radius;
    }

    @Override
    public void move(int x, int y) {
        System.out.println("Circle [" + this.getId() + "] move to (" + x + "," + y + ")");
    }

    @Override
    public void draw() {
        System.out.println("draw a Circle");
    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visitCircle(this);
    }
}
