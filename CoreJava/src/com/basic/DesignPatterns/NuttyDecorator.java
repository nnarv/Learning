package com.basic.DesignPatterns;

public class NuttyDecorator extends IceCreamDecorator{

	public NuttyDecorator(IceCream iceCream) {
		super(iceCream);
	}

	@Override
	public void iceCreamType() {
		iceCream.iceCreamType();
		decoratorType();	
	}

	public void decoratorType() {
		System.out.print(" + Adding Nuts");
		
	}
}
