package com.mimaraslan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MessageProcessorImpl implements MessageProcessor {

    @Autowired
    @Qualifier("aService")
    private SelectService myService;

    public void setMyService(SelectService myService) {
        this.myService = myService;
    }

    public void processMsg(String message) {
        myService.sendMsg(message);
    }
}