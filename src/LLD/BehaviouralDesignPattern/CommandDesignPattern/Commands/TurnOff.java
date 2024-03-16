package LLD.BehaviouralDesignPattern.CommandDesignPattern.Commands;

import LLD.BehaviouralDesignPattern.CommandDesignPattern.CommandInterface.AirConditionerCommand;
import LLD.BehaviouralDesignPattern.CommandDesignPattern.Receiver.AC;

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
