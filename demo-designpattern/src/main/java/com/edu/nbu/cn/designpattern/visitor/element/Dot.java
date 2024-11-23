package com.edu.nbu.cn.designpattern.visitor.element;

import com.edu.nbu.cn.designpattern.visitor.visitor.Visitor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author laoshi . hua
 * @version 1.0 2022/9/2-3:37 PM
 * @since 1.0
 */
@Getter
@Setter
public class Dot implements Shape{
    private int id;
    private int x;
    private int y;

    public Dot(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public Dot() {
    }


    @Override
    public void move(int x, int y) {
        System.out.println("dot [" + id + "] move to (" + x + "," + y + ")");
    }

    @Override
    public void draw() {
        System.out.println("draw a dot");
    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visitDot(this);
    }
}
