package LLD.CreationalPattern.FactoryPattern.Factory;

import LLD.CreationalPattern.FactoryPattern.ConcreteClass.AMDGPU;
import LLD.CreationalPattern.FactoryPattern.ConcreteClass.IntelGPU;

public class GPUFactory {
    public static IntelGPU renderIntelGPU(){
        return new IntelGPU();
    }
    public static AMDGPU renderAMDGPU(){
        return new AMDGPU();
    }
}
