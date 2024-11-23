package com.edu.nbu.cn.designpattern.visitor.element;

import com.edu.nbu.cn.designpattern.visitor.visitor.Visitor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author laoshi . hua
 * @version 1.0 2022/9/2-3:44 PM
 * @since 1.0
 */
@Getter
@Setter
public class CompoundShape implements Shape{
    private int id;
    private List<Shape> children = new ArrayList<>();

    public CompoundShape(int id) {
        this.id = id;
    }

    @Override
    public void move(int x, int y) {
        System.out.println("CompoundShape [" + id + "] move to (" + x + "," + y + ")");
    }

    @Override
    public void draw() {
        System.out.println("draw a CompoundShape!");
    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visitCompoundShape(this);
    }

    public void add(Shape shape){
        children.add(shape);
    }

}
