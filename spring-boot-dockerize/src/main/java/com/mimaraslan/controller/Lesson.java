package com.mimaraslan.controller;

public class Lesson {
	
	public int sum(int[] numbers) {
		int sum = 0;
		for (int i : numbers) {
			sum += i;
		}
		return sum;
	}
	
}