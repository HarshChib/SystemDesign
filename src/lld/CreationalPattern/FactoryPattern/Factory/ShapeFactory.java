package lld.CreationalPattern.FactoryPattern.Factory;

import lld.CreationalPattern.FactoryPattern.ConcreteClass.Circle;
import lld.CreationalPattern.FactoryPattern.ConcreteClass.Rectangle;
import lld.CreationalPattern.FactoryPattern.Interface.Shape;

public class ShapeFactory {
    public static Shape createShape (String shape){
        switch (shape) {
            case "Circle" : return new Circle();
            case "Rectangle" : return new Rectangle();
            default: return null;
        }
    }
}
