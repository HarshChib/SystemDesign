package lld.BehaviouralDesignPattern.NullObjectPattern.ConcreteClass;

import lld.BehaviouralDesignPattern.NullObjectPattern.Interface.Shape;

public class Circle implements Shape {
    @Override
    public void calculate() {
        System.out.println("Circle Area");
    }
}
