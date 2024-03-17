package LLD.CreationalPattern.AbstractFactoryPattern.ConcreteFactory;

import LLD.CreationalPattern.AbstractFactoryPattern.AbstactFactory.ComputerFactory;
import LLD.CreationalPattern.AbstractFactoryPattern.ConcreteClass.IntelCPU;
import LLD.CreationalPattern.AbstractFactoryPattern.ConcreteClass.IntelGPU;

public class IntelComputerFactory implements ComputerFactory {
    @Override
    public IntelCPU createCPU() {
        return new IntelCPU();
    }

    @Override
    public IntelGPU createGPU() {
        return new IntelGPU();
    }
}
