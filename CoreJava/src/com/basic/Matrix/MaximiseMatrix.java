package com.basic.Matrix;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class MaximiseMatrix {
	
	static int matrixMax (int[][] matrix, int rows, int cols){
	    int max = 0;
	    if(matrix==null){
	        return max;
	    }
	    
	    int[] rowSums = new int[rows];
	    int[] colSums = new int[cols];
	    
	    int sum;
	    for (int i=0;i<rows;i++){
	        sum = 0;
	        for(int j=0;j<cols;j++){
	            sum += matrix[i][j];
	        }
	        rowSums[i]=sum;
	    }
	    
	    for (int i=0;i<cols;i++){
	        sum = 0;
	        for(int j=0;j<rows;j++){
	            sum += matrix[j][i];
	        }
	        colSums[i]=sum;
	    }
	    
	    int rowMinSumIndex = mixIndex(rowSums);
	    int rowMinSum = rowSums[rowMinSumIndex];
	    
	    
	    int colMinSumIndex = mixIndex(colSums);
	    int colMinSum = colSums[colMinSumIndex];
	    
	    if(rowMinSum<colMinSum){
	        max = maxSum(rowSums, rowMinSumIndex);
	    }else{
	        max = maxSum(colSums, colMinSumIndex);
	    }
	    
	    return max;
	    
	}

	static int maxSum(int[] sumMatrix, int skipIndex){
	    int max = 0;
	    for(int i=0;i<sumMatrix.length;i++){
	       if(i==skipIndex){
	           continue;
			} else {
				max += sumMatrix[i];
			}
		}
		return max;
	}




	static int mixIndex(int[] sumMatrix){
	    int minIndex = 0;
	    int minValue = sumMatrix[0];
	    for(int i=1;i<sumMatrix.length;i++){
	        if(sumMatrix[i]<minValue){
	            minValue = sumMatrix[i];
	            minIndex = i;
	        }
	    }
	    return minIndex;
	    
	}

	public static void main(String[] args) {
		//Scanner
        Scanner s = new Scanner(System.in);
        String[] first = s.nextLine().split(" ");     
        int rows = Integer.parseInt(first[0]);
        int cols = Integer.parseInt(first[1]);
        
        int matrix[][] = new int[rows][cols];
        
        // Reading input from STDIN
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                matrix[i][j] = s.nextInt();
            }
        }   
        
        System.out.println(matrixMax(matrix, rows,cols));
	}

}
