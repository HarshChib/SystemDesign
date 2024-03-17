package LLD.BehaviouralDesignPattern.TemplatePattern.PaymentTypes;

import LLD.BehaviouralDesignPattern.TemplatePattern.Template.PaymentFlow;

public class MerchantPayment extends PaymentFlow {

    @Override
    public void validate() {
        System.out.println("Merchant Validated");
    }

    @Override
    public void chargeFees() {
        System.out.println("2% fee charged");
    }
}