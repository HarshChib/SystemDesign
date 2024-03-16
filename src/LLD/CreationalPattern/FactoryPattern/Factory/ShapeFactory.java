package LLD.CreationalPattern.FactoryPattern.Factory;

import LLD.CreationalPattern.FactoryPattern.ConcreteClass.Circle;
import LLD.CreationalPattern.FactoryPattern.ConcreteClass.Rectangle;
import LLD.CreationalPattern.FactoryPattern.Interface.Shape;

public class ShapeFactory {
    public static Shape createShape (String shape){
        switch (shape) {
            case "Circle" : return new Circle();
            case "Rectangle" : return new Rectangle();
            default: return null;
        }
    }
}
