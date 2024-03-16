package lld.BehaviouralDesignPattern.CommandDesignPattern.Receiver;

public class AC {
    private final String name;

    public AC(String name){
        this.name = name;
    }
    public void turnOn(){
        System.out.println(name + " AC TURNED ON");
    }

    public void turnOff(){
        System.out.println(name + " AC TURNED OFF");
    }
}
