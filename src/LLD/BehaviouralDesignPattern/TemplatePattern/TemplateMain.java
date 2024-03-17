package LLD.BehaviouralDesignPattern.TemplatePattern;

import LLD.BehaviouralDesignPattern.TemplatePattern.PaymentTypes.FriendPayment;
import LLD.BehaviouralDesignPattern.TemplatePattern.PaymentTypes.MerchantPayment;

public class TemplateMain {
    public static void main(String[] args) {
        FriendPayment friendPayment = new FriendPayment();
        friendPayment.pay();

        MerchantPayment merchantPayment = new MerchantPayment();
        merchantPayment.pay();
    }
}
