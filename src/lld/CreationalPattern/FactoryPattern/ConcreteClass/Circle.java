package lld.CreationalPattern.FactoryPattern.ConcreteClass;

import lld.CreationalPattern.FactoryPattern.Interface.Shape;

public class Circle implements Shape {
    @Override
    public void calculate() {
        System.out.println("Circle Area");
    }
}
