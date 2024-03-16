package LLD.BehaviouralDesignPattern.StrategyPattern.Strategies;

import LLD.BehaviouralDesignPattern.StrategyPattern.Interface.PaymentStrategy;

public class NetBankingStrategy implements PaymentStrategy {
    @Override
    public String pay(double amount) {
        return "Payed "+ amount +" via NetBanking";
    }
}
