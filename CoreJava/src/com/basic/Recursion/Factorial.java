package com.basic.Recursion;

public class Factorial {
	
	static int fact(int n){
		if(n==1){
			return n;
		}
		return n * fact(n-1);
	}

	public static void main(String[] args) {
		System.out.println(Factorial.fact(4));
	}
}