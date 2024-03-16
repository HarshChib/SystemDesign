package lld.BehaviouralDesignPattern.NullObjectPattern;

import lld.BehaviouralDesignPattern.NullObjectPattern.Factory.ShapeFactory;
import lld.BehaviouralDesignPattern.NullObjectPattern.Interface.Shape;

public class NullObjectMain {
    public static void main(String[] args) {
        Shape circle = ShapeFactory.createShape("Circle");
        Shape rectangle = ShapeFactory.createShape("Rectangle");
        Shape square = ShapeFactory.createShape("Square");
        circle.calculate();
        rectangle.calculate();
        square.calculate();
    }
}
