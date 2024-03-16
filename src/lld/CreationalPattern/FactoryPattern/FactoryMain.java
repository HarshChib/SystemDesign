package lld.CreationalPattern.FactoryPattern;

import lld.CreationalPattern.FactoryPattern.Factory.ShapeFactory;
import lld.CreationalPattern.FactoryPattern.Interface.Shape;

public class FactoryMain {
    public static void main(String[] args) {
        Shape circle = ShapeFactory.createShape("Circle");
        Shape rectangle = ShapeFactory.createShape("Rectangle");
        Shape square = ShapeFactory.createShape("Square");
        circle.calculate();
        rectangle.calculate();
        square.calculate();
    }
}
