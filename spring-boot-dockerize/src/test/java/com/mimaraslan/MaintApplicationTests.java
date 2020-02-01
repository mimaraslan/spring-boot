package com.mimaraslan;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mimaraslan.demo.controller.HomeController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MaintApplicationTests {

	@Test
	public void testHomeController() {
		HomeController homeController = new HomeController();
		String result = homeController.getMessage();
		assertEquals(result, "Welcome to Spring Boot with Docker");
	}

}