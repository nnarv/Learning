package com.basic.CodeMonk;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		
		sc.nextLine();
		
		while(sc.hasNext()){
			String line =sc.nextLine();
			String[] arr = line.split(" ");
			System.err.println(arr.length);
		}
		
		//while(test>0){
		//	int checks = sc.nextInt();
			
		//	test--;
		//}
	}

}
