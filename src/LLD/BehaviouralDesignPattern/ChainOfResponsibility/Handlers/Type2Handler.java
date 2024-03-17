package LLD.BehaviouralDesignPattern.ChainOfResponsibility.Handlers;

import LLD.BehaviouralDesignPattern.ChainOfResponsibility.Requests.Request;
import LLD.BehaviouralDesignPattern.ChainOfResponsibility.Requests.RequestType;

public class Type2Handler implements Handler{
    private Handler nextHandler;

    public Type2Handler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
    @Override
    public void handle(Request request) {
        if(request.getType().equals(RequestType.TYPE2)){
            System.out.println("TYPE2 Request Handled");
        }else if(nextHandler != null){
            nextHandler.handle(request);
        } else {
            System.out.println("Can't Handle Request "+request.getType().toString());
        }
    }
}
