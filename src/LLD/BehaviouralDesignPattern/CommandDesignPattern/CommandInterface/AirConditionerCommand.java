package LLD.BehaviouralDesignPattern.CommandDesignPattern.CommandInterface;

import LLD.BehaviouralDesignPattern.CommandDesignPattern.Receiver.AC;

public interface AirConditionerCommand {

    void execute(AC airConditioner);
    void undo(AC airConditioner);
}
