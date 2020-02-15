package com.mimaraslan.v1;

public class AppMain {
	public static void main(String[] args) {
		RubberDuck rubberDuck = new RubberDuck();
		rubberDuck.quack();
		rubberDuck.display();

		MallardDuck mallardDuck = new MallardDuck();
		mallardDuck.display();

		RedheadDuck redheadDuck = new RedheadDuck();
		redheadDuck.display();
	}
}