package com.basic.Recursion;

public class Fibonacci {

	int n1 = 0;
	int n2 = 1;
	int n3;
	
	//Return the n'th fibonacci number
	public int fib(int n){		
		if(n==0 || n==1){
			return n;
		}
		return fib(n-1)+fib(n-2);	
	}
	
	//To print the fibonacci series
	public void printFib(int n){
		if(n > 0){
			n3 = n1+n2;
			n1 = n2;
			n2 = n3;
			System.out.print(n3);
			printFib(n-1);
		}	
	}
	
	public static void main(String[] args) {
		
		int n=9;
		Fibonacci f = new Fibonacci();
		System.out.println(f.fib(n));
		System.out.print("0"+1);
		f.printFib(n-1);

	}

}
