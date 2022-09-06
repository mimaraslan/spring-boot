package com.mimaraslan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MessageProcessorImpl implements MessageProcessor {

    private SelectService selectService;

  //  @Autowired
    public MessageProcessorImpl(@Qualifier("aService") SelectService selectService) {
        this.selectService = selectService;
    }

    public void processMsg(String message) {
        selectService.sendMsg(message);
    }
}