package lld.BehaviouralDesignPattern.NullObjectPattern.ConcreteClass;

import lld.BehaviouralDesignPattern.NullObjectPattern.Interface.Shape;

public class NullObject implements Shape {
    @Override
    public void calculate() {
        System.out.println("Avoiding NullPointerException");
    }
}
