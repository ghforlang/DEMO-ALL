package com.edu.nbu.cn.designpattern.visitor.element;

import com.edu.nbu.cn.designpattern.visitor.visitor.Visitor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author laoshi . hua
 * @version 1.0 2022/9/2-3:41 PM
 * @since 1.0
 */
@Getter
@Setter
public class Rectangle implements Shape{
    private int id;
    private int x;
    private int y;
    private int width;
    private int height;

    public Rectangle(int id, int x, int y, int width, int height) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Rectangle() {
    }


    @Override
    public void move(int x, int y) {
        System.out.println("Rectangle [" + id + "] move to (" + x + "," + y + ")");
    }

    @Override
    public void draw() {
        System.out.println("draw a Rectangle");
    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visitRectangle(this);
    }
}
