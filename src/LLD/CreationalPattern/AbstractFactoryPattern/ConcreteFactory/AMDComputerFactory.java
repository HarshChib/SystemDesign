package LLD.CreationalPattern.AbstractFactoryPattern.ConcreteFactory;

import LLD.CreationalPattern.AbstractFactoryPattern.AbstactFactory.ComputerFactory;
import LLD.CreationalPattern.AbstractFactoryPattern.ConcreteClass.AMDCPU;
import LLD.CreationalPattern.AbstractFactoryPattern.ConcreteClass.AMDGPU;

public class AMDComputerFactory implements ComputerFactory {
    @Override
    public AMDCPU createCPU() {
        return new AMDCPU();
    }

    @Override
    public AMDGPU createGPU() {
        return new AMDGPU();
    }
}