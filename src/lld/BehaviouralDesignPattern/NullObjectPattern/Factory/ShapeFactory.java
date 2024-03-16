package lld.BehaviouralDesignPattern.NullObjectPattern.Factory;

import lld.BehaviouralDesignPattern.NullObjectPattern.ConcreteClass.Circle;
import lld.BehaviouralDesignPattern.NullObjectPattern.ConcreteClass.NullObject;
import lld.BehaviouralDesignPattern.NullObjectPattern.ConcreteClass.Rectangle;
import lld.BehaviouralDesignPattern.NullObjectPattern.Interface.Shape;

public class ShapeFactory {
    public static Shape createShape (String shape){
        switch (shape) {
            case "Circle" : return new Circle();
            case "Rectangle" : return new Rectangle();
            default: return new NullObject();
        }
    }
}
