package com.mimaraslan;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mimaraslan.controller.Lesson;

public class DockerDemoAppTests {
	
	Lesson lesson = new Lesson();

	public void testAdd() {
		String str = "Junit is working fine";
		assertEquals("Junit is working fine", str);
	}
	
	@Before
	public void before() {
		System.out.println("Before");
	}

	@After
	public void after() {
		System.out.println("After");
	}

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Before Class");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("After Class");
	}

	@Test
	public void sum_with3numbers() {
		System.out.println("Test1");
		assertEquals(6, lesson.getSum(new int[] { 1, 2, 3 }));
	}

	@Test
	public void sum_with1number() {
		System.out.println("Test2");
		assertEquals(3, lesson.getSum(new int[] { 3 }));
	}
}