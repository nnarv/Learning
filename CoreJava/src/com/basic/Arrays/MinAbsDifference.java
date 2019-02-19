/**
 * 
 */
package com.basic.Arrays;

/**
 * @author neha.narvekar
 *
 */
public class MinAbsDifference {

	
	// Complete the minimumAbsoluteDifference function below.
    static int minimumAbsoluteDifference(int[] arr) {
        int diff = Integer.MAX_VALUE;
        for (int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
            	System.out.println(Math.abs(arr[i]-arr[j]));
                 if(Math.abs(arr[i]-arr[j])<diff){
                    diff = Math.abs(arr[i]-arr[j]);
                 }
            }  
        }
        return diff;
    }
    
	public static void main(String[] args) {
		int[] arr ={3,-7,0};
		int result = minimumAbsoluteDifference(arr);
		System.err.println(result);

	}

}
