package lld.BehaviouralDesignPattern.StrategyPattern.Context;

import lld.BehaviouralDesignPattern.StrategyPattern.Interface.PaymentStrategy;

public class PaymentContext {
    private final PaymentStrategy paymentStrategy;

    public PaymentContext (PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public String processPayment(double amount) {
        return paymentStrategy.pay(amount);
    }
}
