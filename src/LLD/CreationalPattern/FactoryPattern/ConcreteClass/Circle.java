package LLD.CreationalPattern.FactoryPattern.ConcreteClass;

import LLD.CreationalPattern.FactoryPattern.Interface.Shape;

public class Circle implements Shape {
    @Override
    public void calculate() {
        System.out.println("Circle Area");
    }
}
