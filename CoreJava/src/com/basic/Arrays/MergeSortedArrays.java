/**
 * Given two sorted arrays a[] and b[] of size n and m respectively, the task is to merge both the arrays and rearrange the elements such that the smallest n elements are in a[] and the remaining m elements are in b[]. All elements in a[] and b[] should be in sorted order.

Examples: 

Input: a[] = [2, 4, 7, 10], b[] = [2, 3]
Output: a[] = [2, 2, 3, 4], b[] = [7, 10] 
Explanation: Combined sorted array = [2, 2, 3, 4, 7, 10], array a[] contains smallest 4 elements: 2, 2, 3 and 4, and array b[] contains remaining 2 elements: 7, 10.

Input: a[] = [1, 5, 9, 10, 15, 20], b[] = [2, 3, 8, 13]
Output: a[] = [1, 2, 3, 5, 8, 9], b[] = [10, 13, 15, 20]
Explanation: Combined sorted array = [1, 2, 3, 5, 8, 9, 10, 13, 15, 20], array a[] contains smallest 6 elements: 1, 2, 3, 5, 8 and 9, and array b[] contains remaining 4 elements: 10, 13, 15, 20.

Input: a[] = [0, 1], b[] = [2, 3]
Output: a[] = [0, 1], b[] = [2, 3] 
Explanation: Combined sorted array = [0, 1, 2, 3], array a[] contains smallest 2 elements: 0 and 1, and array b[] contains remaining 2 elements: 2 and 3.
 * 
 */
package com.basic.Arrays;

import java.util.Arrays;

/**
 * 
 */
public class MergeSortedArrays {

	/**
	 * Solution 1 :
	 * 
	 * @param arr1
	 * @param arr2
	 */
	public static void merge(int[] arr1, int[] arr2) {

		int i = 0, temp = 0;
		while (i < arr1.length) {
			if (arr1[i] == arr2[0]) {
				if (i == arr1.length - 1) {
					break;
				}
				temp = arr1[i + 1];
				arr1[i + 1] = arr2[0];
				arr2[0] = temp;
				Arrays.sort(arr2);
			} else {
				if (arr1[i] > arr2[0]) {
					temp = arr1[i];
					arr1[i] = arr2[0];
					arr2[0] = temp;
					Arrays.sort(arr2);
				}
			}
			i++;
		}

		Arrays.stream(arr1).forEach(System.out::print);
		System.out.println();
		Arrays.stream(arr2).forEach(System.out::print);

	}

	/**
	 * Solution 2 : By Swap and Sort
	 * 
 	  Swap the rightmost element in a[] with leftmost element in b[], then second rightmost element in a[] with second leftmost element in b[] and so on. 
 	  This will continue until the selected element from a[] is larger than selected element from b[].

	  When we reach at the pivot index this condition fails automatically and we will stop here. Now sort both the arrays to maintain the order.
	 
	 Time Complexity: O((m+n) + m*log(m) + n*log(n)), where n and m are sizes of a[] and b[] respectively.
	 Auxiliary Space: O(1) 
	 * 
	 * 
	 * @param arr1
	 * @param arr2
	 */
	public static void merge2(int[] arr1, int[] arr2) {

		int i = arr1.length - 1, j = 0, temp = 0;
		while (i >= 0 && j < arr2.length) {
			if (arr1[i] > arr2[j]) {
				temp = arr1[i];
				arr1[i] = arr2[j];
				arr2[j] = temp;
				i--;
				j++;
			} else {
				break;
			}
		}

		Arrays.sort(arr1);
		Arrays.sort(arr2);

		Arrays.stream(arr1).forEach(System.out::print);
		System.out.println();
		Arrays.stream(arr2).forEach(System.out::print);

	}

	/**
	 * Solution 3 : Using Insert of Insertion Sort
	 * 
	The idea is to traverse b[] from the end in reverse order and compare each element with the last (largest) element of a[]. 
	For any index i, if b[i] is greater than the last element of a[], replace b[i] with the last element of a[] and use insert step of insertion sort to find the correct place of b[i] in a[].
	How do we keep a[] sorted? Every time we add any element from b[] to a[], we find the correct index using insert step of insertion sort.
	How do we keep b[] sorted? This is ensured by the fact that we traverse b[] from end and insert only when current element of b[] is smaller.

	Illustration

	Input :
	
	int a[] = {1, 5, 9, 10, 15, 20}
	int b[] = {2, 3, 8, 13}
	
	1st Iteration :
	
	int a[] = {1, 5, 9, 10, 13, 15}
	int b[] = {2, 3, 8, 20}
	
	2nd Iteration :
	
	int a[] = {1, 5, 8, 9, 10, 13}
	int b[] = {2, 3, 15, 20}
	
		
	3rd Iteration :
	
	int a[] = {1, 3, 5, 8, 9, 10}
	int b[] = {2, 13, 15, 20}
	
		
	4th Iteration :
	
	int a[] = {1, 2, 3, 5, 8, 9}
	int b[] = {10, 13, 15, 20}


	Time Complexity: O(m * n), where n and m are sizes of a[] and b[] respectively.
	Auxiliary Space: O(1)

	 * 
	 * @param a
	 * @param b
	 */
	public static void merge3(int[] a, int[] b) {

		int i = b.length - 1,j=0, temp = 0;
		int lastIndex = a.length-1; 
			
		// Traverse b[] starting from the last element
		while (i >= 0) {
			//If the largest element of a is greater than b[i], replace
			if (a[lastIndex] > b[i]) {
				temp = b[i]; // Need to find its correct position to insert in first array
				b[i] = a[lastIndex]; // Move last element of a to b
				j = a.length - 2;

				while (j >= 0 && a[j] > temp) {
					a[j + 1] = a[j];
					j--;
				}

				a[j + 1] = temp;
			}
			
			i--;
		}

		Arrays.stream(a).forEach(System.out::print);
		System.out.println();
		Arrays.stream(b).forEach(System.out::print);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// int[] arr1 = {2, 4, 6, 7, 9};
		// int[] arr2 = {2, 3, 5, 6};

		int[] arr1 = { 1, 3, 4, 4, 5, 7, 7, 8 };
		int[] arr2 = { 6, 7, 9, 9, 9 };

		merge3(arr1, arr2);

	}

}
