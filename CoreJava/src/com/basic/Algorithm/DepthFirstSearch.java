package com.basic.Algorithm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


public class DepthFirstSearch {
	
	
	static class Node{
		int val;
		List<Node> neighbours;
		boolean visited;
		
		Node(int val){
			this.val = val;
			this.neighbours = new LinkedList<>();
		}
		
		void addNeighbour(Node n){
			this.neighbours.add(n);
		}
	}
	
	
	Stack<Node> dfsToBeVisited = new Stack<>();
	
	/**
	 * Iterative method for DFS traversal
	 * @param n
	 */
	void iterativeDFS(Node n){
		dfsToBeVisited.push(n);
		Node next;
		
		while(!dfsToBeVisited.isEmpty()){
			next = dfsToBeVisited.pop();
			if(next!=null && !next.visited){
				System.err.println(next.val);
				next.visited = true;
				for(int i=0;i<next.neighbours.size();i++){
					dfsToBeVisited.push(next.neighbours.get(i));
				}
			}
		}
	}
	
	
	
	/**
	 * Visit a node, suspend and repeat DFS for its neighbours
	 * @param n
	 */
	void DFS(Node n){
		if(n!=null && !n.visited){
			System.err.println(n.val);
			n.visited = true;
			for(Node neigh : n.neighbours){
				if(!neigh.visited){
					DFS(neigh);
				}
			}
		}	
	}
	
	
	Queue<Node> toBeVisited = new LinkedList<>();

	void BFS(Node n){
		toBeVisited.add(n);
		
		Node next;
		
		while(!toBeVisited.isEmpty()){
			next = toBeVisited.poll();
			if(next!=null && !next.visited){
				System.err.println(next.val);
				next.visited = true;
				if(!next.neighbours.isEmpty()){
					toBeVisited.addAll(next.neighbours);
				}
			}
		}
	}
	
	
	
	
	public static void main(String[] args){
		
		Node node40 =new Node(40);
		Node node10 =new Node(10);
		Node node20 =new Node(20);
		Node node30 =new Node(30);
		Node node60 =new Node(60);
		Node node50 =new Node(50);
		Node node70 =new Node(70);
		Node node80 =new Node(80);
		
		node40.addNeighbour(node10);
		node40.addNeighbour(node20);
		node10.addNeighbour(node30);
		node20.addNeighbour(node10);
		node20.addNeighbour(node30);
		node20.addNeighbour(node60);
		node20.addNeighbour(node50);
		node30.addNeighbour(node60);
		node60.addNeighbour(node70);
		node50.addNeighbour(node70);
		node50.addNeighbour(node80);
		
		System.out.println("The DFS traversal of the graph is ");
		DepthFirstSearch dfsExample = new DepthFirstSearch();
		dfsExample.DFS(node40);
		
	//	System.out.println("The BFS traversal of the graph is ");
	//	dfsExample.iterativeDFS(node40);
	}
}
