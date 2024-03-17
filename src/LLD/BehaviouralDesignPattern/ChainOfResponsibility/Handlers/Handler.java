package LLD.BehaviouralDesignPattern.ChainOfResponsibility.Handlers;

import LLD.BehaviouralDesignPattern.ChainOfResponsibility.Requests.Request;

public interface Handler {
    void handle(Request request);
}
