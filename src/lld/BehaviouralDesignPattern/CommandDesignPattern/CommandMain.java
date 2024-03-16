package lld.BehaviouralDesignPattern.CommandDesignPattern;

import lld.BehaviouralDesignPattern.CommandDesignPattern.Commands.TurnON;
import lld.BehaviouralDesignPattern.CommandDesignPattern.Commands.TurnOff;
import lld.BehaviouralDesignPattern.CommandDesignPattern.Invoker.Remote;
import lld.BehaviouralDesignPattern.CommandDesignPattern.Receiver.AC;

public class CommandMain {
    public static void main(String[] args) {
        /*Create AC*/
        AC samsungAC = new AC("Samsung");
        /*Create Remote*/
        Remote samsungACRemote = new Remote(samsungAC);

        /*Execute commands*/
        samsungACRemote.execute(new TurnON());
        samsungACRemote.execute(new TurnOff());
        samsungACRemote.undo();
    }
}
