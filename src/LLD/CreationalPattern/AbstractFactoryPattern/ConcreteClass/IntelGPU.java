package LLD.CreationalPattern.AbstractFactoryPattern.ConcreteClass;

import LLD.CreationalPattern.AbstractFactoryPattern.Interface.GPU;

public class IntelGPU implements GPU {

    @Override
    public void render() {
        System.out.println("Intel GPU renders");
    }
}
