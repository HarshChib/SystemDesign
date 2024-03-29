package LLD.BehaviouralDesignPattern.StrategyPattern.Strategies;

import LLD.BehaviouralDesignPattern.StrategyPattern.Interface.PaymentStrategy;

public class CardStrategy implements PaymentStrategy {
    private final String cardNumber;

    public CardStrategy(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String pay(double amount) {
        return "Payed "+ amount +" via Card : "+cardNumber;
    }
}
