/**
 * 
 */
package com.basic.Sort;

/**
 * @author neha.narvekar
 *
 */
public class QuickSort {

	/**
	 * @param args
	 */
	
	static void sort(int[] input){
		
		int low = 0;
		int high = input.length-1;
		
		quickSort(input, low, high);
	}
	
	public static void quickSort(int[] arr, int low, int high) {
		if (arr == null || arr.length == 0)
			return;
 
		if (low >= high)
			return;
 
		// pick the pivot
		int middle = low + (high - low) / 2;
		int pivot = arr[middle];
 
		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
 
			while (arr[j] > pivot) {
				j--;
			}
 
			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
 
		// recursively sort two sub parts
		if (low < j)
			quickSort(arr, low, j);
 
		if (high > i)
			quickSort(arr, i, high);
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
		System.out.println("\nQuick Sorted Array : ");
		display(inputArray);
		

	}

}
