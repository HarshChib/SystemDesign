package LLD.CreationalPattern.FactoryPattern.ConcreteClass;

import LLD.CreationalPattern.FactoryPattern.Interface.CPU;

public class IntelCPU implements CPU {
    @Override
    public void createCPU() {
        System.out.println("IntelCPU created");
    }
}
