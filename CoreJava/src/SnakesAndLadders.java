import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author neha.narvekar
 *
 */


public class SnakesAndLadders {

	/**
	 * @param args
	 */
	static Map<Integer, Integer> positionMap = new HashMap<Integer, Integer>();
	
	static void createMap(String[] pos){
		
		for(int i=1;i<=30;i++){
			positionMap.put(i, i);
		}
		
		for(int i=0;i<pos.length;i=i+2){
			positionMap.put(Integer.parseInt(pos[i]), Integer.parseInt(pos[i+1]));
		}
	}
	
	static void displayMap(){
		for(int i=1;i<=30;i++){
			System.out.println("Block : "+i +" will lead to " +positionMap.get(i));
		}
	}
	
	static int getBestDestination(int initial){
		int bestMove = 1;
		int bestDestination = initial + bestMove;
		
		int i = 1;
		while(i<=6 && bestDestination!=30){
			int temp = initial+i;
			if(positionMap.get(temp) > bestDestination ){
				bestDestination = positionMap.get(temp);
				bestMove = i;
			}
			i++;
		}
		System.out.println("Best move from "+initial+" is : "+bestMove+" to destination : "+bestDestination);
		return bestDestination;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		System.out.println("No of Test Cases : "+t);
		for(int i=0;i<t;i++){
			int n = sc.nextInt();
			sc.nextLine();
			System.out.println("No of Snakes And Ladders : "+n);
			String[] pos = sc.nextLine().split(" ");
			
			createMap(pos);
			displayMap();
			
			int count = 0;
			int initial = 1;
			int destination = initial;
			while(destination!=30){
				destination = getBestDestination(initial);
				initial = destination;
				count++;
			}
			System.out.println("Minimum moves required : "+count);
		}
	}

}
