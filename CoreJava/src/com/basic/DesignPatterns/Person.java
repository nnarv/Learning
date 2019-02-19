package com.basic.DesignPatterns;

public class Person {
	private String firstName;
	private String middleName; //optional
	private String lastName;
	private int age;
	private String aadhar; //optional
	
	public Person(String firstName, String middleName, String lastName, int age, String aadhar){
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.age = age;
		this.aadhar = aadhar;
	}
	
	@Override
	public String toString(){
		String details = "Person Name : "+ this.firstName + this.middleName + this.lastName;
		return details+this.age+this.aadhar;
	}
	
	
	static class PersonBuilder{
		private String firstName;
		private String middleName; //optional
		private String lastName;
		private int age;
		private String aadhar; //optional
		
		
		public void withFirstName(String first){
			this.firstName = first;
		}
		
		public void withMiddleName(String middle){
			this.middleName = middle;
		}
		
		public void withLastName(String last){
			this.lastName = last;
		}
		
		public void withAge(int age){
			this.age = age;
		}
		
		public void withAadhar(String aadhar){
			this.aadhar = aadhar;
		}
		
		public Person build(){
			return new Person(this.firstName, this.middleName, this.lastName, this.age, this.aadhar);
		}
	}

}
