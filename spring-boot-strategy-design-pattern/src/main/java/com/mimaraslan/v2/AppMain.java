package com.mimaraslan.v2;

public class AppMain {
	public static void main(String[] args) {
		
		RubberDuck rubberDuck = new RubberDuck();
		rubberDuck.display();
		rubberDuck.quack();
		System.out.println("------------------------");

		MallardDuck mallardDuck = new MallardDuck();
		mallardDuck.display();
		mallardDuck.quack();
		mallardDuck.fly();
		System.out.println("------------------------");

		RedheadDuck redheadDuck = new RedheadDuck();
		redheadDuck.display();
		redheadDuck.quack();
		redheadDuck.fly();
		System.out.println("------------------------");

		DecoyDuck decoyDuck = new DecoyDuck();
		decoyDuck.display();
		
	}
}
