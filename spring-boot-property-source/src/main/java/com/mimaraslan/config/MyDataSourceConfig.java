package com.mimaraslan.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.mimaraslan.model.MyDataSource;

@Configuration
@PropertySource("classpath:config.properties")
public class MyDataSourceConfig implements InitializingBean {

	@Autowired
	Environment env;

	@Override
	public void afterPropertiesSet() throws Exception {
		setDatabaseConfig();
	}
	
	private void setDatabaseConfig() {
		MyDataSource myDataSource = new MyDataSource();
		myDataSource.setDriver(env.getProperty("spring.datasource.driver-class-name"));
		myDataSource.setUrl(env.getProperty("spring.datasource.url"));
		myDataSource.setUsername(env.getProperty("spring.datasource.username"));
		myDataSource.setPassword(env.getProperty("spring.datasource.password"));
		System.out.println(myDataSource.toString());
	}

}