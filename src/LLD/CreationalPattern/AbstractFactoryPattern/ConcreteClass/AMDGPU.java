package LLD.CreationalPattern.AbstractFactoryPattern.ConcreteClass;

import LLD.CreationalPattern.AbstractFactoryPattern.Interface.GPU;

public class AMDGPU implements GPU {
    @Override
    public void render() {
        System.out.println("AMG GPU renders");
    }
}
