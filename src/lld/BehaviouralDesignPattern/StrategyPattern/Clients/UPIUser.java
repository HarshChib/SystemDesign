package lld.BehaviouralDesignPattern.StrategyPattern.Clients;

import lld.BehaviouralDesignPattern.StrategyPattern.Context.PaymentContext;
import lld.BehaviouralDesignPattern.StrategyPattern.Strategies.UPIStrategy;

public class UPIUser extends PaymentContext {
    public UPIUser() {
        super(new UPIStrategy());
    }
}
