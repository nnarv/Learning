/*Decorator Design Pattern

To extend or modify the behaviour of ‘an instance’ at runtime decorator design pattern is used. Inheritance is used to extend the 
abilities of ‘a class’. Unlike inheritance, you can choose any single object of a class and modify its behaviour leaving the other 
instances unmodified.

In implementing the decorator pattern you construct a wrapper around an object by extending its behavior. The wrapper will do its job 
before or after and delegate the call to the wrapped instance.

Design of decorator pattern
You start with an interface which creates a blue print for the class which will have decorators. Then implement that interface with 
basic functionalities. Till now we have got an interface and an implementation concrete class. Create an abstract class that 
contains (aggregation relationship) an attribute type of the interface. The constructor of this class assigns the interface type 
instance to that attribute. This class is the decorator base class. Now you can extend this class and create as many concrete decorator 
classes. The concrete decorator class will add its own methods. After / before executing its own method the concrete decorator will call 
the base instance’s method. Key to this decorator design pattern is the binding of method and the base instance happens at runtime based 
on the object passed as parameter to the constructor. Thus dynamically customizing the behavior of that specific instance alone.

 * 
 */



package com.basic.DesignPatterns;

public class DecoratorPattern {

	public static void main(String[] args) {
		
		IceCream ice = new ChocolateDecorator(new NuttyDecorator(new Vanilla()));
		ice.iceCreamType();

	}

}
