package com.mimaraslan.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.mimaraslan")
public class AppConfig {
	
	@Bean
	public MyInterface getAppInfo(
			@Value("${app.name}") String appName, 
			@Value("${server.port}") int appPortNumber) {
		
		return new MyInterface() {
			
			@Override
			public String getAppName() {
				return appName;
			}

			@Override
			public int getAppPortNumber() {
				return appPortNumber;
			}
		};
	}
}