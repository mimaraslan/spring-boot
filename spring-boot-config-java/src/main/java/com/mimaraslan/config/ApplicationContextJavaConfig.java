package com.mimaraslan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.mimaraslan.service.AService;
import com.mimaraslan.service.BService;
import com.mimaraslan.service.CService;
import com.mimaraslan.service.MessageProcessor;
import com.mimaraslan.service.MessageProcessorImpl;
import com.mimaraslan.service.SelectService;

@Configuration
public class ApplicationContextJavaConfig {

	@Bean(name = "aService")
	public SelectService aService() {
		return new AService();
	}

	@Bean(name = "bService")
	public SelectService bService() {
		return new BService();
	}

	@Bean(name = "cService")
	public SelectService cService() {
		return new CService();
	}

	@Bean
	public MessageProcessor messageProcessor() {
		return new MessageProcessorImpl(aService());
	}
}