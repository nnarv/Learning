/**
 * 
 */
package com.basic.Sort;

/**
 * @author neha.narvekar
 *
 */
public class BubbleSort {

	/**
	 * @param args
	 */
	
	static void sort(int[] input){
		for(int i=0;i<input.length;i++){
			for(int j=0;j<input.length-i-1;j++){
				if(input[j]>input[j+1]){
					int temp = input[j];
					input[j]=input[j+1];
					input[j+1]=temp;
				}
			}
		}
	}
	
	 static void display(int[] matrix){
		 for(int i=0;i<matrix.length;i++){
			 System.out.print(matrix[i]+" ");
		 }
	 }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] inputArray = {64, 34, 25, 12, 22, 11, 90};
		System.out.println("Input Array : ");
		display(inputArray);
		sort(inputArray);
		System.out.println("\nBubble Sorted Array : ");
		display(inputArray);
		

	}

}
