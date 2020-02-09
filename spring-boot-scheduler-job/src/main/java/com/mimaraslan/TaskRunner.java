package com.mimaraslan;

import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskRunner {

	// @Scheduled(cron="*/10 * * * * *") //Run every minute
	// @Scheduled(cron = "0 0 14 * * *" , zone = "GMT+5:00")
	@Scheduled(fixedDelayString = "3000") // Fixed delay of 3 secs
	public void run() {
		System.out.println(LocalDateTime.now() + " : Running Scheduled Task!!");
	}
}