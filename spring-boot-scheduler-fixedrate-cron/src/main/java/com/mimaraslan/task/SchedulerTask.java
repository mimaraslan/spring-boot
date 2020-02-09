package com.mimaraslan.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class SchedulerTask {

	private int count = 0;
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Scheduled(fixedRate = 5000)
	public void myJobProcess1() {
		System.err.println((count++) + " ---------------------------------------------");
		System.out.println("Scheduled fixedRate：" + dateFormat.format(new Date()));
	}

	@Scheduled(cron = "*/5 * * * * ?")
	private void myJobProcess2() {
		System.out.println("Scheduled cron：" + dateFormat.format(new Date()));
	}
}

