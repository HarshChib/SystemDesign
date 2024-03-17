package LLD.CreationalPattern.AbstractFactoryPattern;

import LLD.CreationalPattern.AbstractFactoryPattern.AbstactFactory.ComputerFactory;
import LLD.CreationalPattern.AbstractFactoryPattern.ConcreteClass.IntelCPU;
import LLD.CreationalPattern.AbstractFactoryPattern.ConcreteClass.IntelGPU;
import LLD.CreationalPattern.AbstractFactoryPattern.ConcreteFactory.IntelComputerFactory;

public class AbstractFactoryMain {
    public static void main(String[] args) {
        ComputerFactory factory = new IntelComputerFactory();
        IntelCPU intelCPU = (IntelCPU) factory.createCPU();
        IntelGPU intelGPU = (IntelGPU) factory.createGPU();
        intelCPU.process();
        intelGPU.render();
    }
}
