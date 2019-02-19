import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.basic.Algorithm.BreadthFirstSearch;

/**
 * 
 */

/**
 * @author neha.narvekar
 *
 */

class Node{
	int value;
	boolean visited;
	List<Node> neighbours;
	
	Node(int value){
		this.value = value;
		this.neighbours = new ArrayList<>();
	}
	
	void addNeighbour(Node neighbour){
		this.neighbours.add(neighbour);
	}
}

public class SnakeAndLadderBFS {

	Queue<Node> q = new LinkedList<Node>();
	
	void bfs(Node initial){
		q.add(initial);
		initial.visited = true;
		
		while(!q.isEmpty()){
			Node current = q.poll();
			System.out.println(current.value);
			
			List<Node> neighbours = current.neighbours;
			if(neighbours!=null){
				Iterator iterator = neighbours.iterator();
				while(iterator.hasNext()){
					Node neigh = (Node) iterator.next();
					if(!neigh.visited){
						q.add(neigh);
						neigh.visited=true;
					}
					
				}
			}	
		}
	}
	
	public static void main(String[] args) {
		
		List<Node> board = new ArrayList<Node>(30);
		for(int i=1;i<=30;i++){
			Node n = new Node(i);
			board.add(n);
		}
		
		board.get(6).addNeighbour(board.get(8));
		board.get(21).addNeighbour(board.get(18));
		board.get(7).addNeighbour(board.get(17));
		board.get(24).addNeighbour(board.get(23));
		
		System.out.println("The BFS traversal of the graph is ");
		SnakeAndLadderBFS bfsExample = new SnakeAndLadderBFS();
		bfsExample.bfs(board.get(0));
		

	}

}
