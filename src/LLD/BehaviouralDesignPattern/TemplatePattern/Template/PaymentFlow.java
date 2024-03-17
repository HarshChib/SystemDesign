package LLD.BehaviouralDesignPattern.TemplatePattern.Template;

public abstract class PaymentFlow {
    public abstract void validate();
    public abstract void chargeFees();
    public void transfer(){
        System.out.println("Fund Transferred");
    }
    public void sendReceipt(){
        System.out.println("Receipt Sent");
    }

    public final void pay(){
        validate();
        chargeFees();
        transfer();
        sendReceipt();
    }
}
