package com.mimaraslan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import com.mimaraslan.service.MessageProcessor;

@SpringBootApplication
@ImportResource({"classpath*:applicationContext.xml"})
public class SpringBootXmlConfigApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SpringBootXmlConfigApplication.class, args);
		ApplicationContext applicationContext = SpringApplication.run(SpringBootXmlConfigApplication.class, args);

		MessageProcessor userService = applicationContext.getBean(MessageProcessor.class);
		userService.processMsg("A message sending ");
	}

}
