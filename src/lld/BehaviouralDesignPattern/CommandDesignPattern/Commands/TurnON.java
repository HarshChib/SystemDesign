package lld.BehaviouralDesignPattern.CommandDesignPattern.Commands;

import lld.BehaviouralDesignPattern.CommandDesignPattern.CommandInterface.AirConditionerCommand;
import lld.BehaviouralDesignPattern.CommandDesignPattern.Receiver.AC;

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