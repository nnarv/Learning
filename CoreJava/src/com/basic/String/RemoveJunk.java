package com.basic.String;

public class RemoveJunk {

	public static void main(String[] args) {
		String s = "$%^&&* test replace ^&*&*(()(";
		
		System.err.println("Hashcode : "+s.hashCode());
		
		s = s.replaceAll("[^a-zA-Z0-9]", "");
		
		System.out.println(s);
		System.err.println("Hashcode : "+s.hashCode());

	}

}
