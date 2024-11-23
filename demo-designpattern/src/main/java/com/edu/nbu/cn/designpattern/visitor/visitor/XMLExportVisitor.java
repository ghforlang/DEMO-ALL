package com.edu.nbu.cn.designpattern.visitor.visitor;

import com.edu.nbu.cn.designpattern.visitor.element.Circle;
import com.edu.nbu.cn.designpattern.visitor.element.CompoundShape;
import com.edu.nbu.cn.designpattern.visitor.element.Dot;
import com.edu.nbu.cn.designpattern.visitor.element.Rectangle;
import com.edu.nbu.cn.designpattern.visitor.element.Shape;

/**
 * @author laoshi . hua
 * @version 1.0 2022/9/2-4:31 PM
 * @since 1.0
 */
public class XMLExportVisitor implements Visitor{

    public String export(Shape ... shapes){
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>" + " \n");
        sb.append("<configuration>");
        for (Shape shape : shapes){
            sb.append(shape.accept(this)).append("\n");
        }
        sb.append("</configuration>");
        return sb.toString();
    }

    @Override
    public String visitDot(Dot dot) {
        return "\t<dot>" + "\n" +
                "\t\t<id>" + dot.getId() + "</id>" + "\n" +
                "\t\t<x>" + dot.getX() + "</x>" + "\n" +
                "\t\t<y>" + dot.getY() + "</y>" + "\n" +
                "\t</dot>";
    }

    @Override
    public String visitCircle(Circle circle) {
        return "\t<circle>" + "\n" +
                "\t\t<id>" + circle.getId() + "</id>" + "\n" +
                "\t\t<x>" + circle.getX() + "</x>" + "\n" +
                "\t\t<y>" + circle.getY() + "</y>" + "\n" +
                "\t\t<radius>" + circle.getRadius() + "</radius>" + "\n" +
                "\t</circle>";
    }

    @Override
    public String visitRectangle(Rectangle rectangle) {
        return  "\t<rectangle>" + "\n" +
                "\t\t<id>" + rectangle.getId() + "</id>" + "\n" +
                "\t\t<x>" + rectangle.getX() + "</x>" + "\n" +
                "\t\t<y>" + rectangle.getY() + "</y>" + "\n" +
                "\t\t<width>" + rectangle.getWidth() + "</width>" + "\n" +
                "\t\t<height>" + rectangle.getHeight() + "</height>" + "\n" +
                "\t</rectangle>";
    }

    @Override
    public String visitCompoundShape(CompoundShape compoundShape) {
        return  "\n\t<compound_graphic>" + "\n" +
                "\t\t<id>" + compoundShape.getId() + "</id>" + "\n" +
                _visitCompoundGraphic(compoundShape) +
                "\t</compound_graphic>\n";
    }

    private String _visitCompoundGraphic(CompoundShape cg) {
        StringBuilder sb = new StringBuilder();
        for (Shape shape : cg.getChildren()) {
            String obj = shape.accept(this);
            // Proper indentation for sub-objects.
            obj = "    " + obj.replace("\n", "\n    ") + "\n";
            sb.append(obj);
        }
        return sb.toString();
    }
}
