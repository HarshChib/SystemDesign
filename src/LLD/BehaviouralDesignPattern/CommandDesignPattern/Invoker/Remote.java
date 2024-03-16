package LLD.BehaviouralDesignPattern.CommandDesignPattern.Invoker;

import LLD.BehaviouralDesignPattern.CommandDesignPattern.CommandInterface.AirConditionerCommand;
import LLD.BehaviouralDesignPattern.CommandDesignPattern.Receiver.AC;

import java.util.Stack;

public class Remote {
    final AC airConditioner;
    Stack<AirConditionerCommand> commandsExecuted = new Stack<>();
    public Remote(AC airConditioner){
        this.airConditioner = airConditioner;
    }
    public void execute(AirConditionerCommand command){
        commandsExecuted.push(command);
        command.execute(airConditioner);
    }

    public void undo(){
        commandsExecuted.pop().undo(airConditioner);
    }
}
