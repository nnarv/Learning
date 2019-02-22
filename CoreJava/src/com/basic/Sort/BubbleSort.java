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
	
	//Version 1 : Reduce the no.of comparisions in each iteration since the largest element is bubbled to the end
	static void sort(int[] input){
		int temp;
		
		for(int i=0;i<input.length;i++){
			for(int j=0;j<input.length-i-1;j++){
				if(input[j]>input[j+1]){
					temp = input[j];
					input[j]=input[j+1];
					input[j+1]=temp;
				}
			}
		}
	}
	
	
	//Version 2 : All elements are compared in each loop
	static void bubbleSort(int[] input){
		int temp;
		int count = 0;
		while(true){
			for(int j=0;j<input.length-1;j++){
				if(input[j]>input[j+1]){
					temp = input[j];
					input[j]=input[j+1];
					input[j+1]=temp;
				}
			}
			count++;
			if(count == input.length)
				break;
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
		//bubbleSort(inputArray);
		sort(inputArray);
		System.out.println("\nBubble Sorted Array : ");
		display(inputArray);
		

	}

}
