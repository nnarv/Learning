/**
 * As per the encryption is concerned, the encrypted word will start with the middle character of the string and will be 
 * formed henceforth with the middle characters of the left and right substrings (of the middle character of the word) and so on. 
 
 * 	INPUT : The first line contains an integer T denoting the number of TEST CASES. Each TEST CASE consists of 2 lines.
 * 			The first line contains an integer N denoting the length of the word that needs to be encrypted. 
 * 			The second line contains the word that needs to be encrypted.

	OUTPUT : N lines where each line will contain the encrypted words

	CONSTRAINTS :

	1 <= T <= 10
	1 <= Length of the string <= 10000
	
	SAMPLE INPUT 
	2
	3
	abc
	4
	abcd
	
	SAMPLE OUTPUT 
	bac
	bacd
 *
 */
package com.basic.Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author neha.narvekar
 *
 */
public class Encryption {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int testCases = Integer.parseInt(sc.nextLine());
		int size = 0;
		
		List<String> textList = new ArrayList<String>();
		for(int i=0;i<testCases;i++){
			size = Integer.parseInt(sc.nextLine());
			String input = sc.nextLine();
			textList.add(input);
		}
		
		StringBuilder encryptedText = null; 
		for(String text : textList){
			encryptedText = new StringBuilder();
			encrypt(text, encryptedText);
			System.out.println(encryptedText.toString());
		}
		
	}
	
	static void encrypt(String text, StringBuilder encryptedText){
		if(text.length()==0){
			return;
		}
		
		if(text.length()==1){
			encryptedText.append(text);
			return;
		}
		
		int mid = 0;
		if(text.length()%2==1){
			mid = text.length()/2;
		}else{
			mid = text.length()/2 -1;
		}
		
		encryptedText.append(text.charAt(mid));
		encrypt(text.substring(0, mid), encryptedText);
		encrypt(text.substring(mid+1, text.length()), encryptedText);
	}

}
