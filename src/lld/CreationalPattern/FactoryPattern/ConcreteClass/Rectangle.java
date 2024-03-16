package lld.CreationalPattern.FactoryPattern.ConcreteClass;

import lld.CreationalPattern.FactoryPattern.Interface.Shape;

public class Rectangle implements Shape {
    @Override
    public void calculate() {
        System.out.println("Rectangle Area");
    }
}
