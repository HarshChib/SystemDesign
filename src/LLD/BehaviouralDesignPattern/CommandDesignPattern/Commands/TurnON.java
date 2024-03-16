package LLD.BehaviouralDesignPattern.CommandDesignPattern.Commands;

import LLD.BehaviouralDesignPattern.CommandDesignPattern.CommandInterface.AirConditionerCommand;
import LLD.BehaviouralDesignPattern.CommandDesignPattern.Receiver.AC;

public class TurnON implements AirConditionerCommand {

    @Override
    public void execute(AC airConditioner) {
        airConditioner.turnOn();
    }

    @Override
    public void undo(AC airConditioner) {
        airConditioner.turnOff();
    }
}