package LLD.BehaviouralDesignPattern.StrategyPattern;

import LLD.BehaviouralDesignPattern.StrategyPattern.Clients.CardUser;
import LLD.BehaviouralDesignPattern.StrategyPattern.Clients.UPIUser;

/**
 * Used when multiple child classes have common functionality
 * and, we want to avoid code duplication of same logic
 * in the child classes.
 */
public class StrategyMain {
    public static void main(String[] args) {
        CardUser cardUser = new CardUser("2033-1453-8778");
        System.out.println(cardUser.processPayment(100));

        UPIUser upiUser = new UPIUser();
        System.out.println(upiUser.processPayment(200));
    }
}
