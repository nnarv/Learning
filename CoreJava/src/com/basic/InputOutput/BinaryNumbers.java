/**
 * Given a base- integer, , convert it to binary (base-2). 
 * Then find and print the base- integer denoting the maximum number of consecutive 1's in binary representation.
 */
package com.basic.InputOutput;

import java.util.Scanner;

/**
 * @author neha.narvekar
 *
 */
public class BinaryNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int mod = 0, count = 0, maxCount = 0;
		StringBuilder revBinary = new StringBuilder();
		while (n != 0) {
			mod = n % 2;
			n = n / 2;
			revBinary.append(mod);
		}
		String binary = revBinary.reverse().toString();
		System.out.println("Binary : "+binary);
		
		System.out.println("************** TWO LOOPS ****************");
		for (int i = 0; i < binary.length(); i++) {	
			if (binary.charAt(i) == '1') {
				count = 1;	
				for (int j=i+1; j < binary.length(); j++) {
					if (binary.charAt(i) != binary.charAt(j)) 
						break;
					count++;
					
				}
				if (count > maxCount) {
					maxCount = count;	
				}
			}
		}
		System.out.println(maxCount);
		System.out.println("Time complexity : n^2 since 2 loops");
		
		System.out.println("************** ONE LOOP ****************");
		maxCount = 0; count = 1;
		for(int i=0;i<binary.length()-1;i++){
			if(binary.charAt(i)==binary.charAt(i+1) && binary.charAt(i) == '1'){
				count++;
				System.out.println("Count : "+count);
			}else{
				if (count > maxCount) {
					maxCount = count;
				}
				count = 1;
				System.out.println("Max : "+maxCount);
			}
		}
		if (count > maxCount) {
			maxCount = count;
		}
		System.out.println(maxCount);
		
		System.out.println("************** Part 2 ONE LOOP ****************");
		maxCount = 0; count = 1;
		for(int i=0;i<binary.length()-1;i++){
			if(binary.charAt(i) == '1'){
				if(binary.charAt(i)!=binary.charAt(i+1)){
					if (count > maxCount) {
						maxCount = count;
					}
					count = 1;
					System.out.println("Max : "+maxCount);
				}else{
					count++;
				}
			}
		}
		if (count > maxCount) {
			maxCount = count;
		}
		System.out.println(maxCount);
	}

}
