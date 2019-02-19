package com.basic.DesignPatterns;

public class BuilderPattern {

	public static void main(String[] args) {
		
		Person.PersonBuilder builder = new Person.PersonBuilder();
		builder.withFirstName("Ann");
		builder.withLastName("Marie");
		builder.withAge(30);
		System.out.println(builder.build());
	}

}
