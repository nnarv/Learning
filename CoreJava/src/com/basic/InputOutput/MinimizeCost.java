/**
 * 
 */
package com.basic.InputOutput;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * @author neha.narvekar
 *
 */
public class MinimizeCost {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        PrintWriter wr = new PrintWriter(System.out);
	      try{   
	         int n = Integer.parseInt(br.readLine().trim());
	         long k = Long.parseLong(br.readLine().trim());
	         String[] arr_arr = br.readLine().split(" ");
	         int[] arr = new int[n];
	         for(int i_arr=0; i_arr<arr_arr.length; i_arr++)
	         {
	         	arr[i_arr] = Integer.parseInt(arr_arr[i_arr]);
	         }

	         long out_ = Solve(k, arr);
	         System.out.println(out_);

	         wr.close();
	         br.close();
	      }catch(Exception e){
	    	  
	      }
	    }
	
	static void display(int[] x){
		for(int i_arr=0; i_arr<x.length; i_arr++)
        {
        	System.out.print(x[i_arr]);
        }
	}
	    static long Solve(long k, int[] arr){
	        // Write code here
	    	int min = 0;
	    	int n = arr.length;
	        int[] mod = new int[n];
	        
	        for(int i=0;i<n;i++){
	        	if(arr[i]>0){
	        		int current = arr[i];
	        		System.out.println("Current before loop : "+current);
	        		for(int t=1; i+t<n && t<=k && current!=0; t++){
	        			if(arr[i+t]<0){
	        				int temp = Math.abs(arr[i+t]);
	        				if(current <= temp){
	        					mod[i+t] = current;
	        					current = current - temp;
	        				}else{
	        					current = current - temp;
	        					mod[i+t]=temp;
	        				}
	        				System.out.println("Current in loop : "+current);
	        				System.out.println("Mod : "+mod[i+t]);
	        			}
	        			
	        		}
	        		if(current==0){
	        			int y = arr[i];
	        			mod[i] = -y;
	        			System.out.println("Mod to -ve : "+mod[i]);
	        		}else{
	        			int z = arr[i]-current;
	        			mod[i]=-z;
	        		}
	        	}/*else{
	        		mod[i]=arr[i];
	        		System.out.println("Mod to +ve: "+mod[i]);
	        	}*/
	        }
	        
	        System.out.println("Original : ");
	        display(arr);
	        System.out.println("Modified : ");
	        display(mod);
	        
	        for(int x=0;x<n;x++){
	        	 min += arr[x]+mod[x];
	        }
			return min;

	    }

}
