package LLD.CreationalPattern.AbstractFactoryPattern.AbstactFactory;

import LLD.CreationalPattern.AbstractFactoryPattern.Interface.CPU;
import LLD.CreationalPattern.AbstractFactoryPattern.Interface.GPU;

public interface ComputerFactory {
    public CPU createCPU();
    public GPU createGPU();
}
