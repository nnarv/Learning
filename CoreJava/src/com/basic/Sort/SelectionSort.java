/**
 * In selection sort algorithm, we search for the lowest element and arrange it to the proper location.
 */

package com.basic.Sort;

public class SelectionSort {

	public static void display(int[] array){
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
	}
	
	public static void sort(int[] array){
			
		for(int i=0; i<array.length; i++){
			//Consider the ith location as the smallest
			int minIndex = i;
			
			//Find the minIndex by comparision
			for(int j=i+1; j<array.length-1; j++){
				if(array[j] < array[minIndex] ){
					minIndex = j;
				}
			}
			
			if(array[i] > array[minIndex]){  //-----> This comparision is not necessary 
				int temp = array[i];
				array[i] = array[minIndex];
				array[minIndex] = temp;
			}
		}
	}
	
	
	/*  Time complexity : 
		1st iteration : n
		2nd iteration : n-1
		3rd iteration : n-2
		
		nth iteration : 1
		
		= n+ (n-1) + (n-2) + ......... 1 = Sum of first n numbers = n(n+1)/2 
		Hence time complexity of Selection sort = O(n^2)	
	*/
	
	public static void main(String[] args) {
		int [] array = {6, 1, 18, 47, 23, 2, 25, 9, 0, 52};
		System.out.println("Input Array : ");
		SelectionSort.display(array);
		
		sort(array);
		
		System.out.println("\nSorted Array : ");
		SelectionSort.display(array);

	}

}
