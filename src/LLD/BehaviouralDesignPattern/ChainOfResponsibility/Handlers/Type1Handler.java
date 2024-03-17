package LLD.BehaviouralDesignPattern.ChainOfResponsibility.Handlers;

import LLD.BehaviouralDesignPattern.ChainOfResponsibility.Requests.Request;
import LLD.BehaviouralDesignPattern.ChainOfResponsibility.Requests.RequestType;

public class Type1Handler implements Handler{
    private Handler nextHandler;

    public Type1Handler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
    @Override
    public void handle(Request request) {
        if(request.getType().equals(RequestType.TYPE1)){
            System.out.println("TYPE1 Request Handled");
        }else if(nextHandler != null){
            nextHandler.handle(request);
        }
    }
}
