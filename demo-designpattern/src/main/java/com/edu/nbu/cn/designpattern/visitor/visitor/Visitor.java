package com.edu.nbu.cn.designpattern.visitor.visitor;

import com.edu.nbu.cn.designpattern.visitor.element.Circle;
import com.edu.nbu.cn.designpattern.visitor.element.CompoundShape;
import com.edu.nbu.cn.designpattern.visitor.element.Dot;
import com.edu.nbu.cn.designpattern.visitor.element.Rectangle;

/**
 * @author laoshi . hua
 * @version 1.0 2022/9/2-3:36 PM
 * @since 1.0
 */
public interface Visitor {

    String visitDot(Dot dot);

    String visitCircle(Circle circle);

    String visitRectangle(Rectangle rectangle);

    String visitCompoundShape(CompoundShape compoundShape);
}
