package LLD.CreationalPattern.FactoryPattern;

import LLD.CreationalPattern.FactoryPattern.ConcreteClass.AMDCPU;
import LLD.CreationalPattern.FactoryPattern.ConcreteClass.AMDGPU;
import LLD.CreationalPattern.FactoryPattern.ConcreteClass.IntelCPU;
import LLD.CreationalPattern.FactoryPattern.ConcreteClass.IntelGPU;
import LLD.CreationalPattern.FactoryPattern.Factory.CPUFactory;
import LLD.CreationalPattern.FactoryPattern.Factory.GPUFactory;

public class FactoryMain {
    public static void main(String[] args) {
        AMDCPU amdcpu = CPUFactory.createAMDCPU();
        IntelCPU intelCPU = CPUFactory.createIntelCPU();

        AMDGPU amdgpu = GPUFactory.renderAMDGPU();
        IntelGPU intelGPU = GPUFactory.renderIntelGPU();

        amdcpu.createCPU();
        intelCPU.createCPU();

        amdgpu.renderGPU();
        intelGPU.renderGPU();
    }
}
