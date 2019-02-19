package com.basic.DesignPatterns;

public class ChocolateDecorator extends IceCreamDecorator{

	public ChocolateDecorator(IceCream iceCream) {
		super(iceCream);
	}

	@Override
	public void iceCreamType() {
		this.iceCream.iceCreamType();
		decoratorType();
	}

	public void decoratorType() {
		System.out.print(" + Adding Chocolate");
	}

}
