package LLD.CreationalPattern.FactoryPattern.ConcreteClass;

import LLD.CreationalPattern.FactoryPattern.Interface.Shape;

public class Rectangle implements Shape {
    @Override
    public void calculate() {
        System.out.println("Rectangle Area");
    }
}
