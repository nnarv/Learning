package com.basic.DesignPatterns;

public abstract class IceCreamDecorator implements IceCream {
	
	protected IceCream iceCream;
	
	public IceCreamDecorator(IceCream iceCream){
		this.iceCream = iceCream;
	}
	
	public void iceCreamType(){
		this.iceCream.iceCreamType();
	}

}
