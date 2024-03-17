package LLD.BehaviouralDesignPattern.NullObjectPattern;

import LLD.BehaviouralDesignPattern.NullObjectPattern.Factory.ShapeFactory;
import LLD.BehaviouralDesignPattern.NullObjectPattern.Interface.Shape;

public class NullObjectMain {
    public static void main(String[] args) {
        Shape circle = ShapeFactory.createShape("AMDCPU");
        Shape rectangle = ShapeFactory.createShape("IntelCPU");
        Shape square = ShapeFactory.createShape("Square");
        circle.calculate();
        rectangle.calculate();
        square.calculate();
    }
}
