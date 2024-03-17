package LLD.CreationalPattern.AbstractFactoryPattern.ConcreteClass;

import LLD.CreationalPattern.AbstractFactoryPattern.Interface.CPU;

public class AMDCPU implements CPU {
    @Override
    public void process() {
        System.out.println("AMDCPU created");
    }
}
