package com.mimaraslan.v3;

public abstract class Duck {

	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;

	public void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}

	public void setQuackBehavior(QuackBehavior quackBehavior) {
		this.quackBehavior = quackBehavior;
	}

	public void swim() {
		System.out.println("Duck swim");
	}

	public void display() {
		System.out.println("Duck display");
	}

	public void performQuack() {
		System.out.println("Duck performQuack");
		quackBehavior.quack();
	}

	public void performFly() {
		System.out.println("Duck performFly");
		flyBehavior.fly();
	}
}