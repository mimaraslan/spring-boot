package com.mimaraslan.v2;

public class RubberDuck extends Duck implements Quackable {

	public void display() {
		System.out.println("RubberDuck display");
	}

	public void quack() {
		System.out.println("RubberDuck quack");
	}
}