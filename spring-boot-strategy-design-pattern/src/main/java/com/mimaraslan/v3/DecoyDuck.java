package com.mimaraslan.v3;

public class DecoyDuck extends Duck {

	public DecoyDuck() {
		flyBehavior = new FlyWithWings();
		quackBehavior = new Quack();
	}

	public void display() {
		System.out.println("DecoyDuck display");
	}
}