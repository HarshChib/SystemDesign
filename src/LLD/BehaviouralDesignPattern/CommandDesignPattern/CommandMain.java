package LLD.BehaviouralDesignPattern.CommandDesignPattern;

import LLD.BehaviouralDesignPattern.CommandDesignPattern.Commands.TurnON;
import LLD.BehaviouralDesignPattern.CommandDesignPattern.Commands.TurnOff;
import LLD.BehaviouralDesignPattern.CommandDesignPattern.Invoker.Remote;
import LLD.BehaviouralDesignPattern.CommandDesignPattern.Receiver.AC;

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
