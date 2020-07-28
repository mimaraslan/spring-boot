package com.mimaraslan.controller;

public class Lesson {
	
	public int getSum(int[] numbers) {
		int sum = 0;
		for (int i : numbers) {
			sum += i;
		}
		return sum;
	}
	
}