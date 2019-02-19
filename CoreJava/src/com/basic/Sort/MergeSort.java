/**
 * 
 */
package com.basic.Sort;

/**
 * @author neha.narvekar
 *
 */
public class MergeSort {

	/**
	 * @param args
	 */
	
	public static void display(int[] array){
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
	}
		
	public static void merge(int[] array, int low, int mid, int high){
		int[] temp = new int[array.length];
		
		for(int i=low;i<=high;i++){
			temp[i]=array[i];
		}
		
		int i = low;
		int j = mid+1;
		int k = low;
		
		while(i<=mid && j<=high){
			if(temp[i]<temp[j]){
				array[k]=temp[i];
				i++;
			}else{
				array[k]=temp[j];
				j++;
			}
			k++;
		}
		
		while(i<=mid){
			array[k++] = temp[i++];	
		}
		
		/*while(j<=high){
			array[k++]=temp[j++];
		}*/
	}	
	
	public static void sort(int[] array, int low, int high){
		int mid;
		if(low<high){
			mid = (low+high)/2;
			sort(array, low, mid);
			sort(array, mid+1, high);
			merge(array, low, mid, high);
		}
	}
	
	public static void main(String[] args) {
		
		int [] array = {6, 1, 18, 47, 23, 2, 25, 9, 0, 52};
		System.out.println("Input Array : ");
		MergeSort.display(array);
		
		sort(array, 0 , array.length-1);
		
		System.out.println("\nSorted Array : ");
		MergeSort.display(array);	
	}
}
