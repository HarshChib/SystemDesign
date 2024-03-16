package lld.BehaviouralDesignPattern.CommandDesignPattern.Commands;

import lld.BehaviouralDesignPattern.CommandDesignPattern.CommandInterface.AirConditionerCommand;
import lld.BehaviouralDesignPattern.CommandDesignPattern.Receiver.AC;

public class TurnOff implements AirConditionerCommand {

    @Override
    public void execute(AC airConditioner) {
        airConditioner.turnOff();
    }

    @Override
    public void undo(AC airConditioner) {
        airConditioner.turnOn();
    }
}
