package com.mimaraslan.v3;

public class AppMain {
	public static void main(String[] args) {

		RubberDuck rubberDuck = new RubberDuck();
		rubberDuck.display();
		rubberDuck.performFly();
		rubberDuck.performQuack();
		System.out.println("------------------------");

		MallardDuck mallardDuck = new MallardDuck();
		mallardDuck.display();
		mallardDuck.performFly();
		mallardDuck.performQuack();
		System.out.println("------------------------");

		RedheadDuck redheadDuck = new RedheadDuck();
		redheadDuck.display();
		redheadDuck.performFly();
		redheadDuck.performQuack();
		System.out.println("------------------------");

		DecoyDuck decoyDuck = new DecoyDuck();
		decoyDuck.display();
		decoyDuck.performFly();
		decoyDuck.performQuack();
	}
}