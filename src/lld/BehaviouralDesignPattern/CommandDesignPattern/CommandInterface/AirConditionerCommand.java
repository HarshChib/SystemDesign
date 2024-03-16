package lld.BehaviouralDesignPattern.CommandDesignPattern.CommandInterface;

import lld.BehaviouralDesignPattern.CommandDesignPattern.Receiver.AC;

public interface AirConditionerCommand {

    void execute(AC airConditioner);
    void undo(AC airConditioner);
}
