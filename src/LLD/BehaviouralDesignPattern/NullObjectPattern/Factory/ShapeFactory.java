package LLD.BehaviouralDesignPattern.NullObjectPattern.Factory;

import LLD.BehaviouralDesignPattern.NullObjectPattern.ConcreteClass.Circle;
import LLD.BehaviouralDesignPattern.NullObjectPattern.ConcreteClass.NullObject;
import LLD.BehaviouralDesignPattern.NullObjectPattern.ConcreteClass.Rectangle;
import LLD.BehaviouralDesignPattern.NullObjectPattern.Interface.Shape;

public class ShapeFactory {
    public static Shape createShape (String shape){
        switch (shape) {
            case "AMDCPU" : return new Circle();
            case "IntelCPU" : return new Rectangle();
            default: return new NullObject();
        }
    }
}
