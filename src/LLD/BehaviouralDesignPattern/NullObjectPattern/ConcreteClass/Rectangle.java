package LLD.BehaviouralDesignPattern.NullObjectPattern.ConcreteClass;

import LLD.BehaviouralDesignPattern.NullObjectPattern.Interface.Shape;

public class Rectangle implements Shape {
    @Override
    public void calculate() {
        System.out.println("Rectangle Area");
    }
}
