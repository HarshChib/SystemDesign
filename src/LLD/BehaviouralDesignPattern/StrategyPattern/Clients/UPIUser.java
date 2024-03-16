package LLD.BehaviouralDesignPattern.StrategyPattern.Clients;

import LLD.BehaviouralDesignPattern.StrategyPattern.Context.PaymentContext;
import LLD.BehaviouralDesignPattern.StrategyPattern.Strategies.UPIStrategy;

public class UPIUser extends PaymentContext {
    public UPIUser() {
        super(new UPIStrategy());
    }
}
