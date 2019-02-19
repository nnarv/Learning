import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Design {

	public static void main(String[] args) {
	
		int n = 4;
		int j = 0;
		for(int i=0;i<4;i++){
			for(j=0; j<n-i-1 ; j++){
				System.out.print(" ");
			}
			for(int z=0;z<n-j ;z++){
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("\n");
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(0, "Zero");
		map.put(1, "One");
		map.put(2, "Two");
		map.put(3, "Three");
		map.put(4, "Four");
		
		System.out.println("\n");
		//One
		System.err.println(" Type 1 ");
		for(Integer key : map.keySet()){
			System.out.println(map.get(key));
		}
		
		System.out.println("\n");
		//Two
		System.err.println(" Type 2 ");
		for(Entry<Integer, String> s: map.entrySet()){
			System.out.println(s.getValue());
		}
		
		
	}

}
