package LLD.BehaviouralDesignPattern.StrategyPattern.Strategies;

import LLD.BehaviouralDesignPattern.StrategyPattern.Interface.PaymentStrategy;

public class UPIStrategy implements PaymentStrategy {
    @Override
    public String pay(double amount) {
        return "Payed "+ amount +" via UPI";
    }
}
