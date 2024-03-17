package LLD.CreationalPattern.FactoryPattern.ConcreteClass;

import LLD.CreationalPattern.FactoryPattern.Interface.GPU;

public class AMDGPU implements GPU {
    @Override
    public void renderGPU() {
        System.out.println("AMG GPU renders");
    }
}
