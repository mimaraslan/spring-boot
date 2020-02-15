package com.mimaraslan.v3;

public class MallardDuck extends Duck {

	public MallardDuck() {
		flyBehavior = new FlyNoWay();
		quackBehavior = new Quack();
	}

	public void display() {
		System.out.println("MallardDuck display");
	}
}