package com.mimaraslan.service;

public class MessageProcessorImpl implements MessageProcessor {

    private SelectService myService;

    public void setMyService(SelectService myService) {
        this.myService = myService;
    }

    public void processMsg(String message) {
        myService.sendMsg(message);
    }
}