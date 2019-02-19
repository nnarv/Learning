/**
We define super digit of an integer  using the following rules:

Given an integer, we need to find the super digit of the integer.

If  has only  digit, then its super digit is .
Otherwise, the super digit of  is equal to the super digit of the sum of the digits of .
For example, the super digit of  will be calculated as:

	super_digit(9875)   	9+8+7+5 = 29 
	super_digit(29) 	2 + 9 = 11
	super_digit(11)		1 + 1 = 2
	super_digit(2)		= 2  

n: a string representation of an integer
k: an integer, the times to concatenate n to make p 

Input Format
The first line contains two space separated integers,  and .

Output Format
Return the super digit of p  

Sample Input :
148 3

Sample Output :
3
 * 
 */
package com.basic.Recursion;

import java.util.Scanner;

/**
 * @author neha.narvekar
 *
 */
public class SuperDigit {

	 static int superDigit(String n, int k) {
	        StringBuilder build = new StringBuilder();
	        for(int i=0;i<k;i++){
	            build.append(n);
	        }
	        String input = build.toString();
	        System.out.println("Input : "+input);
	        
	        int sum = 0;
	        while(input.length()>1){
	        	if(sum>0){
	        		input=String.valueOf(sum);
	        	}
	        	sum=0;
	        	for(int i=0;i<input.length();i++){
		        	char c = input.charAt(i);
		        	sum+= Character.getNumericValue(c);
		        }
	        }
	        return sum;

	    }

    private static final Scanner scanner = new Scanner(System.in);
    
	public static void main(String[] args) {
	//     String[] nk = scanner.nextLine().split(" ");

	     String n = "123";
	     int k = 3;

	     int result = superDigit(n, k);

	     System.out.println("Super Digit : "+result);

	}

}
