package com.mimaraslan.v3;

public class RubberDuck extends Duck {

	public RubberDuck() {
		flyBehavior =  new FlyWithWings();
		quackBehavior = new Quack();
	}
	
	public void display() {
		System.out.println("RubberDuck display");
	}
}