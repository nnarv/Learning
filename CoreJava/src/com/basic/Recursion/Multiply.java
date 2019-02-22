package com.basic.Recursion;

public class Multiply {

	
	static public int multiply(int a, int b){
		
		if(b==1){
			return a;
		}
		return a + multiply(a,b-1);
	}
		
	public static void main(String[] args) {	
		System.out.println(Multiply.multiply(11, 6));
	}
}
