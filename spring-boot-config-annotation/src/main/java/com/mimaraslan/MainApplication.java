package com.mimaraslan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mimaraslan.service.MessageProcessor;

@SpringBootApplication
public class MainApplication {
	
	private static Logger LOG = LoggerFactory.getLogger(MainApplication.class);

	public static void main(String[] args) {
		LOG.info("STARTING THE APPLICATION");
		ApplicationContext applicationContext = SpringApplication.run(MainApplication.class, args);
		
		MessageProcessor messageProcessor = applicationContext.getBean(MessageProcessor.class);
		messageProcessor.processMsg("Message sending ");
		LOG.info("APPLICATION FINISHED");
	}

}
