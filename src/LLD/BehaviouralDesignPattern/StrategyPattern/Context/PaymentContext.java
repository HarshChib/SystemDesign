package LLD.BehaviouralDesignPattern.StrategyPattern.Context;

import LLD.BehaviouralDesignPattern.StrategyPattern.Interface.PaymentStrategy;

public class PaymentContext {
    private final PaymentStrategy paymentStrategy;

    public PaymentContext (PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public String processPayment(double amount) {
        return paymentStrategy.pay(amount);
    }
}
