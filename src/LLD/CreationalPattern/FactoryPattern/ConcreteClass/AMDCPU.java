package LLD.CreationalPattern.FactoryPattern.ConcreteClass;

import LLD.CreationalPattern.FactoryPattern.Interface.CPU;

public class AMDCPU implements CPU {
    @Override
    public void createCPU() {
        System.out.println("AMDCPU created");
    }
}
