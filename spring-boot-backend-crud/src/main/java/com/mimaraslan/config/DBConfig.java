package com.mimaraslan.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class DBConfig {

    @Value("${myinfo}")
    private String myinfo;

    @Bean
    @Profile("dev")
    public String getSourceProps() {
        System.out.println("My info: "+ myinfo);
        return "Source connection for dev";
    }
}
