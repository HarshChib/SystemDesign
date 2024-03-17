package LLD.CreationalPattern.AbstractFactoryPattern.ConcreteClass;

import LLD.CreationalPattern.AbstractFactoryPattern.Interface.CPU;

public class IntelCPU implements CPU {
    @Override
    public void process() {
        System.out.println("IntelCPU created");
    }
}
