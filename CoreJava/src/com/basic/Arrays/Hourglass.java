/**
 *

We define an hourglass in  to be a subset of values with indices falling in this pattern in 's graphical representation:

	a b c
	  d
	e f g
	
There are 16  hourglasses in arr, and an hourglass sum is the sum of an hourglass' values. 
Calculate the hourglass sum for every hourglass in arr , then print the maximum hourglass sum.

For example, given the 2D array:

-9 -9 -9  1 1 1 
 0 -9  0  4 3 2
-9 -9 -9  1 2 3
 0  0  8  6 6 0
 0  0  0 -2 0 0
 0  0  1  2 4 0
 
We calculate the following 16 hourglass values:

-63, -34, -9, 12, 
-10, 0, 28, 23, 
-27, -11, -2, 10, 
9, 17, 25, 18

Our highest hourglass value is 28 from the hourglass:

0 4 3
  1
8 6 6
 
*/
package com.basic.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author neha.narvekar
 *
 */
public class Hourglass {

	 // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
    	int sum = 0;
    	List<Integer> hours = new ArrayList<Integer>();
    	for(int l=0;l<4;l++){
    		for(int k=0;k<4;k++){
    			sum = 0;
    			for(int i=l;i<l+3 && i<arr.length; i++){
    				
    				for(int j=k;j<k+3 && j<arr.length; j++){
    					//System.err.println("value at : i="+i+" & j=" +j+" : "+arr[i][j]);
    					//System.err.println(arr[i][j]);
    					if(i==l+1){
        					sum += arr[i][j+1];
        					break;
        				}
    					sum += arr[i][j];
    				}
    				//System.out.println("\n");
    			}
    			//System.err.println("Sum : " +sum);
    			hours.add(sum);
    		}
    	}
    	
    	/*for(int i=0;i<4;i++){
    		for(int j=0;j<4;j++){
    			
    		}
    	}*/
    	
    	int max = 0;
    	for(int z:hours){
    		if(z>max){
    			max=z;
    		}
    	}
    	return max;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = {
				{-9, -9, -9,  1, 1, 1}, 
				{0, -9,  0,  4, 3, 2},
				{-9, -9, -9,  1, 2, 3},
				 {0,  0,  8,  6, 6, 0},
				 {0,  0,  0, -2, 0, 0},
				 {0,  0,  1,  2, 4, 0}
			};
		
		System.out.println(hourglassSum(arr));

	}

}
