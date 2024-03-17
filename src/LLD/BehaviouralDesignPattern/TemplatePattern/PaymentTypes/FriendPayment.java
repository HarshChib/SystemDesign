package LLD.BehaviouralDesignPattern.TemplatePattern.PaymentTypes;

import LLD.BehaviouralDesignPattern.TemplatePattern.Template.PaymentFlow;

public class FriendPayment extends PaymentFlow {

    @Override
    public void validate() {
        System.out.println("Friend Validated");
    }

    @Override
    public void chargeFees() {
        System.out.println("No fee charged");
    }
}
