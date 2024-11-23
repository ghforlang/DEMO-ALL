package com.edu.nbu.cn.designpattern.visitor;

import com.edu.nbu.cn.designpattern.visitor.element.Circle;
import com.edu.nbu.cn.designpattern.visitor.element.CompoundShape;
import com.edu.nbu.cn.designpattern.visitor.element.Dot;
import com.edu.nbu.cn.designpattern.visitor.element.Rectangle;
import com.edu.nbu.cn.designpattern.visitor.element.Shape;
import com.edu.nbu.cn.designpattern.visitor.visitor.XMLExportVisitor;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @author laoshi . hua
 * @version 1.0 2022/9/2-5:40 PM
 * @since 1.0
 */
public class Demo {


    public static void main(String[] args) throws IOException {
        String filePath = Demo.class.getResource("").getPath();
        File file = new File(filePath + "demo.xml");
        Dot dot = new Dot(1,20,20);
        Circle circle = new Circle(2,20,30,10);
        Rectangle rectangle = new Rectangle(3,10,14,20,30);

        CompoundShape compoundShape = new CompoundShape(4);
        compoundShape.add(dot);
        compoundShape.add(circle);
        compoundShape.add(rectangle);

        CompoundShape c = new CompoundShape(5);
        c.add(dot);
        compoundShape.add(c);

        FileUtils.write(file,export(compoundShape,c),Charset.forName("UTF-8"));
        System.out.println("success!");
    }

    private static String export(Shape ... shapes){
        XMLExportVisitor xmlExportVisitor = new XMLExportVisitor();
        return xmlExportVisitor.export(shapes);
    }
}
