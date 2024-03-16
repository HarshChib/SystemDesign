package lld.BehaviouralDesignPattern.StrategyPattern.Clients;

import lld.BehaviouralDesignPattern.StrategyPattern.Context.PaymentContext;
import lld.BehaviouralDesignPattern.StrategyPattern.Strategies.CardStrategy;

public class CardUser extends PaymentContext {
    public CardUser(String cardNumber) {
        super(new CardStrategy(cardNumber));
    }
}
