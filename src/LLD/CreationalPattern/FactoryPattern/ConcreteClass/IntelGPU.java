package LLD.CreationalPattern.FactoryPattern.ConcreteClass;

import LLD.CreationalPattern.FactoryPattern.Interface.GPU;

public class IntelGPU implements GPU {

    @Override
    public void renderGPU() {
        System.out.println("Intel GPU renders");
    }
}
