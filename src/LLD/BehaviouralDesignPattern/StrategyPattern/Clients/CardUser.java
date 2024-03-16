package LLD.BehaviouralDesignPattern.StrategyPattern.Clients;

import LLD.BehaviouralDesignPattern.StrategyPattern.Context.PaymentContext;
import LLD.BehaviouralDesignPattern.StrategyPattern.Strategies.CardStrategy;

public class CardUser extends PaymentContext {
    public CardUser(String cardNumber) {
        super(new CardStrategy(cardNumber));
    }
}
