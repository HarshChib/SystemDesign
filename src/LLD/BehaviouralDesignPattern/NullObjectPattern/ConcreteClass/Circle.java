package LLD.BehaviouralDesignPattern.NullObjectPattern.ConcreteClass;

import LLD.BehaviouralDesignPattern.NullObjectPattern.Interface.Shape;

public class Circle implements Shape {
    @Override
    public void calculate() {
        System.out.println("Circle Area");
    }
}
