/**You are assigned to develop a cipher program to encrypt the message. Your cipher must rotate every character in the message by a fixed number making it unreadable by enemies. 
Given a single line of string 'S' containing alpha, numeric and symbols, followed by a number '0<=N<=1000'. Encrypt and print the resulting string.
Note: The cipher only encrypts Alpha and Numeric. (A-Z, a-z, and 0-9) . All Symbols, such as - , ; %, remain unencrypted.
 
SAMPLE INPUT
All-convoYs-9-be:Alert1.
4

SAMPLE OUTPUT
Epp-gsrzsCw-3-fi:Epivx5.

Explanation 
First line contains the string to convert. S
Second line contains the number, encrypt key. K
A becomes E, Y becomes C, 9 becomes 3,
-, . unchanged.
 
*/
package com.basic.InputOutput;

import java.util.Scanner;

/**
 * @author neha.narvekar
 *
 */
public class Cipher {

	/**
	 * @param args
	 */
	

	public static void main(String[] args) {
	
		 Scanner sc = new Scanner(System.in);
	     String input = sc.nextLine();
	     int k = sc.nextInt();
	     StringBuilder cipher = new StringBuilder();
	     
	     if(input!=null && !input.isEmpty()){
	    	 for(int i=0;i<input.length();i++){
	    		 int x = input.charAt(i);	
	    		 if(Character.isLowerCase(input.charAt(i))){
	    		    int t = x+k-(k/26*26);
	    			 if(t > 122){
	    				cipher.append(Character.toString((char) (t-26))); 
	    			 }else{
	    				 cipher.append(Character.toString((char) (t))); 
	    			 }
	    		 }else if(Character.isUpperCase(input.charAt(i))){
	    		     int z = x+k-(k/26*26);
		    		if(z > 90){
		    			cipher.append(Character.toString((char) (z-26))); 
		    		}else{
		    			 cipher.append(Character.toString((char) (z))); 
		    		} 
	    		 }else if(Character.isDigit(input.charAt(i))){
	    		     int h = x+k-(k/10*10);
	    			 if(h > 57){		
			    			cipher.append(Character.toString((char) (h-10))); 
			    		}else{
			    			 cipher.append(Character.toString((char) (h))); 
			    		} 
	    		 }else{
                    cipher.append(String.valueOf(input.charAt(i)));  
                 }	 
	    	 }
	     }
	     
	     System.out.println("Cipher : "+cipher.toString());
	}
}
