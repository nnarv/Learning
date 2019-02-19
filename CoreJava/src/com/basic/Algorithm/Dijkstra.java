package com.basic.Algorithm;

import java.util.Scanner;

public class Dijkstra {
	
	private static int edges;
	private static int vertices;
	
	private static int[][] matrix ;
	private static int[] distance ;
	private static boolean[] visited ;
	
	private static void initialize(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the no.of vertices : ");
		vertices = sc.nextInt();
		System.out.println("Enter the no.of edges : ");
		edges = sc.nextInt();
		
		matrix = new int[vertices][vertices];
		System.out.println("Enter the matrix values in the form : v1 v2 weight");
		for(int i=0;i<edges;i++){
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			int weight = sc.nextInt();
			matrix[v1][v2] = weight;
			matrix[v2][v1] = weight;		
		}
		
		distance = new int[vertices];
		visited = new boolean[vertices];
		
	}
	
	private static int findMinVertex(){
		int minVertex = -1;
		for(int i=0;i<vertices;i++){
			if(!visited[i] && (minVertex==-1 || distance[i] < distance[minVertex])){
				minVertex = i;
			}
		}
		return minVertex;
	}

	public static void main(String[] args) {
		
		initialize();
		
		distance = matrix[0];
		distance[0] = 0;
		for(int i=1;i<vertices;i++){
			if(distance[i]==0){
				distance[i] = Integer.MAX_VALUE;
			}
		}
		visited[0] = true;
		
		
		for(int i=0;i<vertices-1;i++){
			int minVertex = findMinVertex();
			visited[minVertex] = true;
			
			for(int j=0;j<vertices;j++){
				if(matrix[minVertex][j]!=0 && !visited[j] && distance[minVertex]!=Integer.MAX_VALUE){
					int newDistance = distance[minVertex]+matrix[minVertex][j];
					if(newDistance<distance[j]){
						distance[j] = newDistance;
					}
				}
				
			}
	
		}
		
		for(int i=0;i<vertices;i++){
			System.out.println(distance[i]);
		}
		
		

	}

}
