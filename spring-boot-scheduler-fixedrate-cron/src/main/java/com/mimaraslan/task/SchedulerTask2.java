package com.mimaraslan.task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerTask2 {

	private static final Logger logger = LoggerFactory.getLogger(SchedulerTask2.class);
	private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
	
	@Scheduled(fixedRate = 6000)
	//@Scheduled(fixedDelay = 6000)
	public void getCurrentTime() {
		logger.info("\nTime is now {}", simpleDateFormat.format(new Date()));
		try {
			TimeUnit.MILLISECONDS.sleep(4000);
		}
		catch(InterruptedException e) {}
	}
	
}
