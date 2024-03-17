package LLD.BehaviouralDesignPattern.ChainOfResponsibility;

import LLD.BehaviouralDesignPattern.ChainOfResponsibility.Handlers.Handler;
import LLD.BehaviouralDesignPattern.ChainOfResponsibility.Handlers.Type1Handler;
import LLD.BehaviouralDesignPattern.ChainOfResponsibility.Handlers.Type2Handler;
import LLD.BehaviouralDesignPattern.ChainOfResponsibility.Requests.Request;
import LLD.BehaviouralDesignPattern.ChainOfResponsibility.Requests.RequestType;

public class CorMain {
    public static void main(String[] args) {
        Handler handlerChain = new Type1Handler(new Type2Handler(null));

        handlerChain.handle(new Request(RequestType.TYPE1));
        handlerChain.handle(new Request(RequestType.TYPE2));
        handlerChain.handle(new Request(RequestType.TYPE3));
    }
}
