/**
 * 
 */
package com.basic.Algorithm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



/**
 * @author neha.narvekar
 *
 */
public class BreadthFirstSearch {

	Queue<Node> q = new LinkedList<Node>();
	static class Node{
		
		int value;
		boolean visited;
		List<Node> neighbours;
		
		Node(int value){
			this.value = value;
			this.neighbours = new ArrayList<Node>();
		}
		
		public void addNeighbour(Node neighbour){
			this.neighbours.add(neighbour);
		}
	}

	void BFS(Node initial){
		q.add(initial);
		initial.visited=true;
		
		while(!q.isEmpty()){		
			Node current = q.poll();
			System.out.println(current.value+"\t");
				
			List<Node> neighbours = current.neighbours;
			Iterator<Node> iterator = neighbours.iterator();
			while(iterator.hasNext()){
				Node next = iterator.next();
				if(!next.visited){
					q.add(next);
					next.visited = true;
					
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		Node node40 =new Node(40);
		Node node10 =new Node(10);
		Node node20 =new Node(20);
		Node node30 =new Node(30);
		Node node60 =new Node(60);
		Node node50 =new Node(50);
		Node node70 =new Node(70);
 
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
		System.out.println("The BFS traversal of the graph is ");
		BreadthFirstSearch bfsExample = new BreadthFirstSearch();
		bfsExample.BFS(node40);

	}

}
