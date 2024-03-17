package LLD.CreationalPattern.FactoryPattern.Factory;

import LLD.CreationalPattern.FactoryPattern.ConcreteClass.AMDCPU;
import LLD.CreationalPattern.FactoryPattern.ConcreteClass.IntelCPU;
import LLD.CreationalPattern.FactoryPattern.Interface.CPU;

public class CPUFactory {
    public static IntelCPU createIntelCPU(){
        return new IntelCPU();
    }
    public static AMDCPU createAMDCPU(){
        return new AMDCPU();
    }
}
