/**
 * 
 */
package com.basic.InputOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author neha.narvekar
 *
 */
public class EvenOdd {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Scanner sc = new Scanner(System.in);
	        int num = sc.nextInt();
	        List<String> input = new ArrayList<String>();
	        while(num!=0){
	            input.add(sc.next());
	            num--;
	        }
	       
	        System.out.println(input.size());
	        for(int i=0; i<input.size();i++){
	            String text = input.get(i);
	            if(text!=null){
	                StringBuilder even = new StringBuilder();
	                StringBuilder odd = new StringBuilder();

	                for(int j=0;j<text.length();j++){
	                    if(j%2==0){
	                        even.append(String.valueOf(text.charAt(j)));
	                    }else{
	                        odd.append(String.valueOf(text.charAt(j))); 
	                    }
	                }
	                System.out.println(even.toString()+" "+odd.toString());

	            }
	        }

	}

}
